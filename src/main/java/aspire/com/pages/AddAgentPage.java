package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import jo.aspire.generic.StateHelper;
import jo.aspire.mobile.automationUtil.Helper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.IOException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class AddAgentPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public AddAgentPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * Select/Click element in the first page system backup wizard.
	 * 
	 * @param element:
	 *            element name.
	 */
	public void selectElementFromSystemBackupWizard(String element) {
		element = element.replace(" ", "_");
		waitElementToBeVisible(element, CONST_WAIT_HIGHER_VALUE);
		clickOnElement(element);
	}

	/**
	 * fill text in Host name text box and click next it, then return if the IP
	 * is valid.
	 * 
	 * @param text:
	 *            text to be filled.
	 * @return boolean
	 */
	public boolean fillTextInHostName(String text) {
		if (text.equalsIgnoreCase("windows")) {
			text = getProperty(text);
		}
		clickOnElement("IpAddressOrHost");
		enterTextInElement(text, "IpAddressTextBox");
		clickOnElement("NextButton");
		if (waitElementToBeVisible("nextIcon")) {
			clickOnElement("NextButton");
			return true;
		}
		return false;
	}

	/**
	 * this method is used to check if the window is display and keep the
	 * default settings and click on next button, otherwise return false.
	 * 
	 * @param windowName:
	 *            name of the window to check.
	 * @return boolean
	 */
	public boolean keepTheDefaultSettingsInWindow(String windowName) {
		windowName = windowName.replace(" ", "_");
		boolean isWindowDisplay = waitElementToBeVisible(windowName);
		if (isWindowDisplay) {
			clickOnElement("NextButton");
		}
		return isWindowDisplay;
	}

	/**
	 * this method is used to enter text in email text box in system backup
	 * wizard windows ("receive screenshot proof","send alerts & reports") and
	 * return true or false based on window displaying.
	 * 
	 * @param text:
	 *            text to be filled.
	 * @param windowName:
	 *            window name to be checked.
	 * 
	 * @return boolean
	 */
	public boolean fillEmails(String text, String windowName) {
		sleepTime(2000);
		boolean isWindowDisplayed = isElementDisplayed(windowName);
		if (isWindowDisplayed) {
			if (windowName.equals("receive screenshot proof")) {
				enterTextInElement(text, "EmailAddress");
			} else {
				enterTextInElement(text, "WarningEmail");
				clickOnElement("CriticalEmail");
				enterTextInElement(text, "CriticalEmail");
				clickOnElement("LogDigestEmail");
				enterTextInElement(text, "LogDigestEmail");
			}
			clickOnElement("NextButton");
		}
		return isWindowDisplayed;
	}

	/**
	 * this method is used to check if the system or agent is added and
	 * successful message displayed
	 * 
	 * @return boolean
	 */
	public boolean systemShouldBeProtected() {
		return waitElementToBeVisible("AgentCreated");
	}

}