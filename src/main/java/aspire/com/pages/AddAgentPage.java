package aspire.com.pages;

import java.sql.Connection;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import jo.aspire.generic.StateHelper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;

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
		text = getProperty(text);
		// an example on state helper to use value in other step
		StateHelper.setStoryState("machineIP", text);
		clickOnElement("IpAddressOrHost");
		enterTextInElement(text, "IpAddressTextBox");
		return waitElementToBeVisible("IpAddressTextBox");
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
		return waitElementToBeVisible(windowName);
	}

	/**
	 * this method is used to enter text in screenshot email field in system
	 * backup wizard windows "receive screenshot proof"
	 * 
	 * @param text:
	 *            text to be filled.
	 */
	public void fillScreenshotEmail(String text) {
		enterTextInElement(text, "EmailAddress");
	}

	/**
	 * this method is used to enter text in Warning email field in system backup
	 * wizard windows "send alerts & reports"
	 * 
	 * @param text:
	 *            text to be filled.
	 */
	public void fillWarningEmail(String text) {
		clickOnElement("WarningEmail");
		enterTextInElement(text, "WarningEmail");
	}

	/**
	 * this method is used to enter text in Critical email field in system
	 * backup wizard windows "send alerts & reports"
	 * 
	 * @param text:
	 *            text to be filled.
	 */
	public void fillCriticalEmail(String text) {
		clickOnElement("CriticalEmail");
		enterTextInElement(text, "CriticalEmail");
	}

	/**
	 * this method is used to enter text in Log Digest email field in system
	 * backup wizard windows "send alerts & reports"
	 * 
	 * @param text:
	 *            text to be filled.
	 */
	public void fillLogDigestEmail(String text) {
		clickOnElement("LogDigestEmail");
		enterTextInElement(text, "LogDigestEmail");
	}

	/**
	 * this method is used to check if the system or agent is added and
	 * successful message displayed
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean agentShoudBeCreated() throws InterruptedException {
		return waitElementToBeVisible("AgentCreated");
	}

	/**
	 * this method is used to check if the system or agent is added and
	 * successful message displayed
	 * 
	 * @return boolean
	 * @throws InterruptedException
	 */
	public boolean agentBlockShouldBeDisplay() throws InterruptedException {

		return waitElementToBeVisible("AgentBlock");

	}

	public boolean validateIPAddress() {
		clickOnElement("NextButton");
		return waitElementToBeVisible("nextIcon");
	}

	public void clickNextButton() {
		clickOnElement("NextButton");
	}

	public void clickContinueButton() {
		clickOnElement("Continue");
	}
	public void clickVerifyButton() {
		clickOnElement("Verify");
	}

	public boolean stateHelperCase() {
		sleepTime(3000);
		return findElement(By.id(StateHelper.getStoryState("machineIP").toString())).isDisplayed();
	}

}