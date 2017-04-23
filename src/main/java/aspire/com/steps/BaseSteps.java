package aspire.com.steps;

import aspire.com.pages.AddAgentPage;
import aspire.com.pages.ConfigureAgentSettingsPage;
import aspire.com.pages.GenericPage;
import aspire.com.pages.LoginPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import aspire.com.pages.PageFactory;
import aspire.com.pages.ProtectPage;
import aspire.com.pages.RemoveAgentPage;
import aspire.com.pages.RestorePage;

@ContextConfiguration("file:cucumber.xml")
public class BaseSteps {

	@Autowired
	PageFactory pageFactory = null;
	private GenericPage genericPage;
	private AddAgentPage addAgentPage;
	private ConfigureAgentSettingsPage configureAgentSettingsPage;
	private LoginPage loginPage;
	private ProtectPage protectPage;
	private RemoveAgentPage removeAgentPage;
	private RestorePage restorePage;
	public BaseSteps() {

	}

	public BaseSteps(PageFactory pageFactory) {
		this.pageFactory = pageFactory;
	}

	public GenericPage getGenericPage() {
		if (genericPage == null) {
			genericPage = pageFactory.genericPage();
		}
		return genericPage;
	}

	public AddAgentPage getAddAgentPage() {
		if (addAgentPage == null) {
			addAgentPage = pageFactory.addAgentPage();
		}
		return addAgentPage;
	}

	public ConfigureAgentSettingsPage getConfigureAgentSettingsPage() {
		if (configureAgentSettingsPage == null) {
			configureAgentSettingsPage = pageFactory.configureAgentSettingsPage();
		}
		return configureAgentSettingsPage;
	}

	public LoginPage getloginPage() {
		if (loginPage == null) {
			loginPage = pageFactory.loginPage();
		}
		return loginPage;
	}

	public ProtectPage getProtectPage() {
		if (protectPage == null) {
			protectPage = pageFactory.protectPage();
		}
		return protectPage;
	}

	public RemoveAgentPage getRemoveAgentPage() {
		if (removeAgentPage == null) {
			removeAgentPage = pageFactory.removeAgentPage();
		}
		return removeAgentPage;
	}
	
	public RestorePage getRestorePage() {
		if (restorePage == null) {
			restorePage = pageFactory.restorePage();
		}
		return restorePage;
	}
}
