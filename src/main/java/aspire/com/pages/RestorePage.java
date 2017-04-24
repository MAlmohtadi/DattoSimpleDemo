package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jo.aspire.generic.StateHelper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.util.HashMap;

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
	 * This method is used to remove any previous restored points and perform
	 * new restore point.
	 *
	 */
	public void performRestore() {
		clickOnElement("RestoreMenu");
		sleepTime(1000);
		try {
			waitElementToBeVisible("RemoveRestore", 10);
			clickOnElement("RemoveRestore");
			sleepTime(5000);
			waitElementToBeVisible("ForceUnmount", 10);
			clickOnElement("ForceUnmount");
		} catch (Exception e) {
			System.out.println("there is no previous restored points");
		}
		clickOnElement("ChooseSystemRadioButton");
		clickOnElement("FileRestoreRadioButton");
		clickOnElement("StartFileRestore");
		sleepTime(2000);
		clickOnElement("Mount");
		try {
			waitElementToBeVisible("PassphraseTextBox", 10);
			enterTextInElement("123", "PassphraseTextBox");
			sleepTime(3000);
			clickOnElement("VerifyPhraseButton");
		} catch (Exception e) {
			System.out.println("system not encrypted");
		}
		waitElementToBeVisible("Unmount", CONST_WAIT_LOWER_VALUE);
	}

	/**
	 * this method is used if the file exist in the given URL.
	 * 
	 * @param nameOfFile:
	 *            name of the file to be checked.
	 * @param volumeName:
	 *            volume name that has the given file.
	 * @return Integer.
	 * @throws MalformedURLException.
	 * @throws SmbException.
	 */
	public int getHashCodeForSharedFile(String nameOfFile, String volumeName)
			throws MalformedURLException, SmbException {
		String tempText = getElementByCssSelector("ShareURL").getText().replace("Samba Share:\n\\\\", "")
				.replace("\\", "/").trim();
		String url = "smb://" + tempText;
		SmbFile dir = new SmbFile(url);
		url = url + File.separator + volumeName + File.separator + nameOfFile;
		dir = new SmbFile(url);
		return dir.hashCode();
	}

	/**
	 * check files that have been saved and compare hash codes with the saved
	 * hashes for the files that have been removed.
	 * 
	 * @param numberOfFiles:
	 *            number of files.
	 * @param volumesName:
	 *            volumes name separated by comma.
	 * @return boolean
	 * @throws MalformedURLException
	 * @throws SmbException
	 */
	public boolean verifyRestoredFiles(String numberOfFiles, String volumesName)
			throws MalformedURLException, SmbException {
		int counter = Integer.parseInt(numberOfFiles);
		boolean isRestored = true;
		String[] volumesArray = volumesName.split(",");
		HashMap<String, Integer> files = (HashMap<String, Integer>) StateHelper.getStoryState(volumesArray[0]);

		for (int i = 0; i < volumesArray.length; i++) {
			for (int j = 1; j <= counter; j++) {
				isRestored = (getHashCodeForSharedFile("Test" + j + ".txt", volumesArray[i]) == files.get("Test" + j));
				if (!isRestored) {
					return isRestored;
				}
			}
		}
		return isRestored;
	}

}