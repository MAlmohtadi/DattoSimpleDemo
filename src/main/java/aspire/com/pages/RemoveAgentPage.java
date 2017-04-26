package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.IOException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class RemoveAgentPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public RemoveAgentPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * this method is used to remove agent by enter text in confirm
	 * 
	 * @param text:
	 *            text to be entered in confirm filed
	 */
	public void removeAgent(String text) {

		enterTextInElement(text, "RemoveAgentConfirm");
		clickOnElement("RemoveAgentDelete");
	}

}