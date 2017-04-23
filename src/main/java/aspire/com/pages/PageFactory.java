package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import jo.aspire.automation.logger.EnvirommentManager;

/**
 * PageFactory that is used to instantiate desired page object
 */

public class PageFactory {

	private WebDriverProvider webDriverProvider;

	public PageFactory(WebDriverProvider webDriverProvider) {
		EnvirommentManager.setInitialClass(this.getClass());
		this.webDriverProvider = webDriverProvider;
	}

	public WebDriverProvider getDriverProvider() {
		return webDriverProvider;
	}

	public GenericPage genericPage() {
		return new GenericPage(webDriverProvider);
	}

	public AddAgentPage addAgentPage() {
		return new AddAgentPage(webDriverProvider);
	}

	public ConfigureAgentSettingsPage configureAgentSettingsPage() {
		return new ConfigureAgentSettingsPage(webDriverProvider);
	}

	public LoginPage loginPage() {
		return new LoginPage(webDriverProvider);
	}

	public ProtectPage protectPage() {
		return new ProtectPage(webDriverProvider);
	}

	public RemoveAgentPage removeAgentPage() {
		return new RemoveAgentPage(webDriverProvider);
	}
	public RestorePage restorePage() {
		return new RestorePage(webDriverProvider);
	}
}
