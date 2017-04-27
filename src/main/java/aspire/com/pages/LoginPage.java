package aspire.com.pages;

import java.io.IOException;
import java.sql.Connection;

import org.jbehave.web.selenium.WebDriverProvider;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

/**
 * Page object defining the home page
 */
public class LoginPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public LoginPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * This method used to login using valid user name and password.
	 * 
	 * @throws IOException
	 */
	public void login() throws IOException {
		get(getProperty("LoginPage"));
		getDriverProvider().get().manage().window().maximize();
		waitElementToBeVisible("Username", CONST_WAIT_HIGHER_VALUE);
		enterTextInElement(getProperty("ValidUsername"), "Username");
		enterTextInElement(getProperty("ValidPassword"), "Password");
		clickOnElement("LoginButton");
		waitElementToBeVisible("TopMenu", CONST_WAIT_HIGHER_VALUE);
	}

}