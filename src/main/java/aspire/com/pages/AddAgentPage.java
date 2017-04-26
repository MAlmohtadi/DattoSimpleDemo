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

	public void selectElementFromSystemBackupWizard(String element) {
		element=element.replace(" ", "_");
		waitElementToBeVisible(element, CONST_WAIT_HIGHER_VALUE);
		clickOnElement(element);

	}

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

	public boolean keepTheDefaultSettingsInWindow(String windowName) {
		windowName = windowName.replace(" ", "_");
		boolean isWindowDisplay = waitElementToBeVisible(windowName);
		if (isWindowDisplay) {
			clickOnElement("NextButton");
		}
		return isWindowDisplay;
	}

	public void fillEmails(String text, String windowName) {
		if (windowName.equals("receive screensot proof")) {
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

	public boolean systemShouldBeProtected() {
		return waitElementToBeVisible("AgentCreated");
	}

	public void fillTextInElement(String text, String element) {
		element = element.replace(" ", "");
		enterTextInElement(text, element);
		if (element.contains("Repeat")) {
			clickOnElement("NextButton");
		}
		if (element.contains("Verify")) {
			clickOnElement("Verify");
		}

	}

}