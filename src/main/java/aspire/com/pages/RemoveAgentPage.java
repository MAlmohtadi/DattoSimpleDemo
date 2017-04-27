package aspire.com.pages;

import java.sql.Connection;

import org.jbehave.web.selenium.WebDriverProvider;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

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
	public void removeAgent(String text, String element) {
		enterTextInElement(text, element);
		clickOnElement("RemoveAgentDelete");
	}

}