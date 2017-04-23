package aspire.com.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import com.google.inject.Key;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jo.aspire.automation.logger.EnvirommentManager;
import jo.aspire.generic.StateHelper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;
import junit.framework.Assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Page object defining the home page
 */
public class GenericPage extends FluentWebDriverPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public GenericPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public static boolean isExecluded = false;
	String imgsPath = System.getProperty("user.dir") + File.separator + "imgs/";
	/**
	 * Default Selector within the class
	 */
	public By Version = cssSelector("td.mh22-text a");
	public final int CONST_WAIT_LOWER_VALUE = 30;
	public final int CONST_WAIT_HIGHER_VALUE = 90;

	public FluentWebElement getWorkSmartVersion() {
		return within(secs(CONST_WAIT_LOWER_VALUE)).link(Version);
	}

	/**
	 * Get value of the key from properties.
	 * 
	 * @param keyInProperties:
	 *            name of key.
	 * @return String.
	 */
	public String getProperty(String keyInProperties) {
		return EnvirommentManager.getInstance().getProperty(keyInProperties);
	}

	/**
	 * Wait an element to be visible on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 * @param timeInSeconds:
	 *            time to wait.
	 */
	public void waitElementToBeVisible(String elementName, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(getProperty(elementName))));
	}

	/**
	 * Wait an element to be visible on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 */
	public boolean waitElementToBeVisible(String elementName) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), CONST_WAIT_LOWER_VALUE);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(getProperty(elementName))));
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}

		return true;
	}

	/**
	 * Wait an element to be able to click on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 * @param timeInSeconds:
	 *            time to wait.
	 */
	public void waitElementToBeClickable(String elementName, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(getProperty(elementName))));
	}

	/**
	 * Get an element by Css selector then return it as WebElement
	 * 
	 * @param elementName:
	 *            name of element to be find.
	 * @return WebElement.
	 */
	public WebElement getElementByCssSelector(String elementName) {
		return findElement(By.cssSelector(getProperty(elementName)));
	}

	/**
	 * Enter a text in a text field element.
	 * 
	 * @param text:
	 *            text to be entered.
	 * @param elementName:
	 *            name of the element to be enter text in it.
	 */
	public void enterTextInElement(String text, String elementName) {
		waitElementToBeVisible(elementName, CONST_WAIT_LOWER_VALUE);
		getElementByCssSelector(elementName).sendKeys(getProperty(text));
	}

	/**
	 * Click on element by its CSS selector.
	 * 
	 * @param elementName:
	 *            element name to get it's value from properties file.
	 */
	public void clickOnElement(String elementName) {
		waitElementToBeClickable(elementName, CONST_WAIT_LOWER_VALUE);
		getElementByCssSelector(elementName).click();
	}

	/**
	 * this method is used in special cases to pause the running for a period of
	 * time.
	 * 
	 * @param seconds:
	 *            number of seconds for sleep.
	 */
	public void sleepTime(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete files from volumes based on name of the file and name of the
	 * volume.
	 * 
	 * @param nameOfFile:
	 *            name of the file to be deleted.
	 * @param nameOfVolume:
	 *            name of the volume that contains the file.
	 */
	public void deleteFiles(String nameOfFile, String nameOfVolume) {
		try {

			File file = new File(nameOfVolume + File.separator + nameOfFile + ".txt");
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
				Assert.assertEquals(true, false);
			}

		} catch (Exception e) {
			System.out.println("File Path not exist");
		}
	}

	/**
	 * Add a file to volumes based on name of the file and name of the volume.
	 * 
	 * @param ipAddress:
	 *            IP To connect to machine.
	 * @param file:
	 *            name of the file to be added.
	 * @param nameOfVolume:
	 *            name of the volume to add the file to it.
	 * 
	 */
	public void addFile(String ipAddress, String nameOfVolume, String file) {
		Writer writer = null;
		try {
			try {
				new File(new URI("file:////" + ipAddress + "/" + nameOfVolume + "$/workspace/" + file)).createNewFile();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(ipAddress + nameOfVolume + File.separator + file)));
			writer.write(loremText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get the IP address for this machine.
	 * 
	 * @return String.
	 */
	public String getMyIP() {
		CommandLine commandLine;

		commandLine = new CommandLine("cmd.exe", "/C", "ipconfig");
		commandLine.execute();

		String instancePath = (commandLine.getStdOut()).trim();
		instancePath = instancePath.split("Wireless LAN adapter Wireless Network Connection:")[1]
				.split("Ethernet adapter Local Area Connection:")[0].split("IPv4 Address. . . . . . . . . . . : ")[1]
						.split("Subnet Mask . . . . . . . . . . . :")[0].trim();
		return instancePath;
	}

	/**
	 * Check if element displays by it's CSS selector.
	 * 
	 * @param nameOfElement:
	 *            name of the element
	 * @return Boolean.
	 */
	public boolean isElementDisplayed(String nameOfElement) {
		return getElementByCssSelector("ProtectedSystemsHeader").isDisplayed();
	}

	// /**
	// * this method is used to create new files in the following volumes E,H
	// and
	// * I.
	// *
	// * @param nameOfTheFile:
	// * of the file to be create.
	// * @throws UnsupportedEncodingException
	// * @throws FileNotFoundException
	// * @throws IOException
	// * @throws FindFailed
	// */
	// public void createAFile(String nameOfTheFile)
	// throws UnsupportedEncodingException, FileNotFoundException, IOException {
	//
	// addFile(nameOfTheFile, "E");
	// addFile(nameOfTheFile, "H");
	// addFile(nameOfTheFile, "I");
	//
	// }

	/**
	 * this method is used to delete the files with Test name from E,H and I
	 * volumes.
	 * 
	 * @param number:
	 *            of files to be removed.
	 */
	public void deleteFilesAndTakeBackup(String number) {
		int counter = Integer.parseInt(number);
		for (int i = 1; i <= counter; i++) {
			deleteFiles("Test" + i, "E");
			deleteFiles("Test" + i, "H");
			deleteFiles("Test" + i, "I");
		}

	}

	/**
	 * this method is used to click on image using sikulix.
	 * 
	 * @param imageName:
	 *            image name.
	 * @throws FindFailed.
	 */
	public void selectElement(String imageName) throws FindFailed {

		Screen screen = new Screen();
		screen.wait(imgsPath + imageName + ".png", 20);
		screen.click(imgsPath + imageName + ".png");
	}

	public void createTextFileRemotly(String fileNumber, String volumesName) {
		// String ipAddress =
		// StateHelper.getApplicationState("machineIP").toString();
		String ipAddress = getProperty("Windows").toString();
		int numberOfFiles = Integer.parseInt(fileNumber);
		String[] volumesArray = volumesName.split(",");
		for (int i = 0; i < numberOfFiles; i++) {
			for (int j = 0; j < volumesArray.length; j++) {
				addFile(ipAddress, volumesArray[j], "Test" + i + ".txt");
			}
		}

	}

	public String loremText() {
		return "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. "
				+ "Aenean commodo ligula eget dolor. Aenean massa. "
				+ "Cum sociis natoque penatibus et magnis dis parturient montes, "
				+ "nascetur ridiculus mus. Donec quam felis, ultricies nec, "
				+ "pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, "
				+ "fringilla vel, aliquet nec, vulputate eget, arcu. " + "In enim justo, rhoncus ut, imperdiet a, "
				+ "venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. " + "Integer tincidunt. "
				+ "Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. "
				+ "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. "
				+ "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. "
				+ "Phasellus viverra nulla ut metus varius laoreet. "
				+ "Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. "
				+ "Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, "
				+ "tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. "
				+ "Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. "
				+ "Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus. "
				+ "Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. "
				+ "Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. "
				+ "Sed consequat, leo eget bibendum sodales, augue velit cursus nunc,";
	}

	public boolean waitImageToBeVisible(String imageName) {
		Screen screen = new Screen();
		try {
			screen.wait(imgsPath + imageName + ".png", CONST_WAIT_LOWER_VALUE);
		} catch (FindFailed e) {

			System.err.println(e);
			return false;
		}
		return true;

	}
}