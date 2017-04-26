package aspire.com.pages;

import org.apache.commons.io.FileUtils;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jo.aspire.generic.StateHelper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class RestorePage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public RestorePage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");
	private final int CONST_WAIT_LOWER_VALUE = 30;

	/**
	 * this method is used if the file exist in the given URL and copy it to
	 * project directory.
	 * 
	 * @param nameOfFile:
	 *            name of the file to be checked.
	 * @param volumeName:
	 *            volume name that has the given file.
	 * @return String.
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws MalformedURLException.F
	 */
	public String getSharedFileURI(String nameOfFile, String volumeName) throws IOException, URISyntaxException {
		String tempText = getElementByCssSelector("Samba_Share").getText().replace("Samba Share:\n\\\\", "")
				.replace("\\", "/").trim();
		String url = "smb://" + tempText;
		SmbFile file = new SmbFile(url);
		url = url + File.separator + volumeName + File.separator + nameOfFile;
		file = new SmbFile(url);
		url = file.getURL().toString();
		url = url.replace("smb://", "").replace("\\", "/");
		return url;
	}

	/**
	 * check files that have been restores and compare if the content
	 * equivalent.
	 * 
	 * @param numberOfFiles:
	 *            number of files.
	 * @param fileName:
	 *            name of the file.
	 * @param volumesName:
	 *            volumes name separated by comma.
	 * @return boolean
	 * @throws MalformedURLException
	 * @throws SmbException
	 */
	public boolean verifyRestoredFiles(String numberOfFiles, String fileName, String volumesName)
			throws MalformedURLException, SmbException {
		int counter = Integer.parseInt(numberOfFiles);
		boolean isRestored = false;
		String[] volumes = volumesName.split(",");
		File file = new File(System.getProperty("user.dir") + File.separator + "files" + File.separator + "Test.txt");
		boolean isOneFile = false;
		File sharedFile = null;
		if (counter == 1) {
			isOneFile = true;
		}
		for (int i = 0; i < volumes.length; i++) {
			for (int j = 1; j <= counter; j++) {
				try {
					if (isOneFile) {
						sharedFile = new File(new URI("file:////" + getSharedFileURI(fileName, volumes[i])));
					} else {
						sharedFile = new File(new URI("file:////" + getSharedFileURI(j + fileName, volumes[i])));
					}
					isRestored = FileUtils.contentEquals(sharedFile, file);
					if (!isRestored) {
						return isRestored;
					}
				} catch (URISyntaxException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		return isRestored;
	}

	public void removeRestoredPoints() {
		sleepTime(5000);
		boolean isDisplayed = isElementDisplayed("RecoverySection");
		if (isDisplayed) {
			waitElementToBeClickable("RemoveRestore", CONST_WAIT_LOWER_VALUE);
			Iterator<WebElement> removeButtons = findElements(By.cssSelector(getProperty("RemoveRestore"))).iterator();
			WebElement element = null;
			while (removeButtons.hasNext()) {
				element = removeButtons.next();
				element.click();
				sleepTime(5000);
				removeButtons = findElements(By.cssSelector(getProperty("RemoveRestore"))).iterator();
			}
		}

	}

	public void chooseOptionInForRestore(String option) {
		option = option.replace(" ", "");
		if (!option.equalsIgnoreCase("last")) {
			clickOnElement(option);
		}

	}

}