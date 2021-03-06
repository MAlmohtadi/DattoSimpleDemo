package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.IOException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

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
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");

	/**
	 * This method used to login using valid user name and password
	 * 
	 * @throws IOException
	 */
	public void login() throws IOException {
		get(getProperty("LoginPage"));
		getDriverProvider().get().manage().window().maximize();
		waitElementToBeVisible("Username", CONST_WAIT_HIGHER_VALUE);
		enterTextInElement("ValidUsername", "Username");
		enterTextInElement("ValidPassword", "Password");
		clickOnElement("LoginButton");
		waitElementToBeVisible("TopMenu", CONST_WAIT_HIGHER_VALUE);
	}

}