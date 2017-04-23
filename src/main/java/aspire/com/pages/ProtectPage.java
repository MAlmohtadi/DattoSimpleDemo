package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class ProtectPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public ProtectPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public final int CONST_WAIT_SPECIAL_USAGE = 400;
	/**
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");

	/**
	 * this method is used to take a backup in DATTO appliance.
	 * 
	 * @throws FindFailed
	 */
	public void takeBackup() throws FindFailed {
		Screen screen = new Screen();
		screen.click(imgsPath + "protect.png");
		screen.wait(imgsPath + "Start Backup.png", CONST_WAIT_HIGHER_VALUE);
		screen.click(imgsPath + "Start Backup.png");
		screen.wait(imgsPath + "Cancel.png", CONST_WAIT_HIGHER_VALUE);
	}

	/**
	 * This method used to check if the back up finished.
	 * 
	 * @return Boolean.
	 * @throws FindFailed
	 */
	public boolean verifyBuckupFunctionality() throws FindFailed {
		Screen screen = new Screen();
		screen.wait(imgsPath + "Last Successful backup.png", CONST_WAIT_SPECIAL_USAGE);
		return screen.exists(imgsPath + "Last Successful backup.png") != null;
	}

//	/**
//	 * This method is used to create files in all volumes then create a backup.
//	 * 
//	 * @param number:
//	 *            number of files to be created in each volume.
//	 * @throws FindFailed.
//	 */
//	public void createTextFilesAndTakeBackup(String number, String volumes) throws FindFailed {
//		int counter = Integer.parseInt(number);
//		String[] volumesArray = volumes.split(",");
//		for (int i = 1; i <= counter; i++) {
//			for (int j = 0; j < volumesArray.length; j++) {
//				createFileRemotly("Test" + i + ".txt", volumesArray[j]);
//			}
//		}
//		takeBackup();
//	}
	//
	// /**
	// * this method is used for DATTO system agent to check if the system agent
	// * is protected or not.
	// *
	// * @return Boolean.
	// */
	// public boolean checkSystemIsCreatedAndProtected() {
	// waitElementToBeVisible("AgentCreated", CONST_WAIT_SPECIAL_USAGE);
	// clickOnElement("Continue");
	// waitElementToBeVisible("ProtectedSystemsHeader", CONST_WAIT_LOWER_VALUE);
	// return isElementDisplayed("ProtectedSystemsHeader");
	// }

}