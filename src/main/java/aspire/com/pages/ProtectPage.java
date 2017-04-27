package aspire.com.pages;

import java.sql.Connection;

import org.jbehave.web.selenium.WebDriverProvider;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

/**
 * Page object defining the home page
 */
public class ProtectPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public ProtectPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public final int CONST_WAIT_SPECIAL_USAGE = 600;

	/**
	 * This method used to check if the back up finished.
	 * 
	 * @return boolean.
	 * @throws FindFailed
	 */
	public boolean verifyBuckupFunctionality() throws FindFailed {
		Screen screen = new Screen();
		screen.wait(imgsPath + "Last Successful backup.png", CONST_WAIT_SPECIAL_USAGE);
		return screen.exists(imgsPath + "Last Successful backup.png") != null;
	}

	/**
	 * this method is used to click on PROTECT and Check if system page header
	 * displayed.
	 * 
	 * @return boolean
	 */
	public boolean checkIfSystemProtected() {
		return waitElementToBeVisible("ProtectedSystemsHeader");
	}

	public void clickProtectButton() {
		clickOnElement("PROTECT");
	}

	/**
	 * this method is used to click on start backup and wait cancel button to be
	 * displayed to deal with taking one backup.
	 * 
	 * @return boolean
	 * @throws FindFailed
	 */
	public boolean takeOneBackup() throws FindFailed {
		if (waitImageToBeVisible("Start Backup")) {
			selectElement("Start Backup");
			return waitImageToBeVisible("Cancel");
		}
		return false;
	}

}