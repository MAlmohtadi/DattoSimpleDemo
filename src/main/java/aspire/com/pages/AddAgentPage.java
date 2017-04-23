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
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");

	/**
	 * add an Agent Based System in DATTO appliance.
	 * 
	 * @param typeOfSystem:
	 *            type of system to be added.
	 * @param osType:
	 *            type of the operating system to work on it.
	 */
	public void addAgentBasedSystem(String typeOfSystem, String osType) {
//		waitElementToBeVisible("AddBasedSystem", CONST_WAIT_HIGHER_VALUE);
//		clickOnElement("AddBasedSystem");
//		clickOnElement("IpAddressOrHost");
//		enterTextInElement(getProperty(osType), "IpAddressTextBox");

		clickOnElement("NextButton");
		sleepTime(2000);
		clickOnElement("NextButton");
		waitElementToBeVisible("LocalBackups", CONST_WAIT_LOWER_VALUE);
		clickOnElement("NextButton");
		waitElementToBeVisible("CloudBackups", CONST_WAIT_LOWER_VALUE);
		clickOnElement("NextButton");
		waitElementToBeVisible("RetentionBackups", CONST_WAIT_LOWER_VALUE);
		clickOnElement("NextButton");
		enterTextInElement("malmohtadi@aspire-infotech.net", "EmailAddress");
		clickOnElement("NextButton");
		waitElementToBeVisible("AlerAndReports", CONST_WAIT_LOWER_VALUE);
		enterTextInElement("malmohtadi@aspire-infotech.net", "CriticalEmail");
		clickOnElement("NextButton");
		waitElementToBeVisible("EncryptSection", CONST_WAIT_LOWER_VALUE);
		if (typeOfSystem.contains("not")) {
			clickOnElement("EncryptYes");
			clickOnElement("IAgreeButton");
//			clickOnElement("NextButton");
			sleepTime(2000);
			enterTextInElement("123", "EnterPassphrase");
			sleepTime(2000);
			enterTextInElement("123", "RepeatPassphrase");
			sleepTime(2000);
		}
		clickOnElement("NextButton");
	}

}