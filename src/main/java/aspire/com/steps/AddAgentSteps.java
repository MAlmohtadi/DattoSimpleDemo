package aspire.com.steps;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import aspire.com.pages.PageFactory;
import cucumber.api.java.Before;

public class AddAgentSteps extends BaseSteps {

	public AddAgentSteps() {
		super();
	}

	public AddAgentSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
		System.out.println("ttt");
	}

	@When("selecting '$element' from system backup wizard")
	public void selectElementFromSystemBackupWizard(String element) {
		getAddAgentPage().selectElementFromSystemBackupWizard(element);
	}

	@When("filling '$text' Address in 'Hostname'")
	public void fillTextInHostName(String text) {
		assertThat(getAddAgentPage().fillTextInHostName(text), Matchers.equalTo(true));
		assertThat(getAddAgentPage().validateIPAddress(), Matchers.equalTo(true));
		getAddAgentPage().clickNextButton();
	}

	@When("keeping the default settings in '$windowName' window")
	public void keepTheDefaultSettingsInWindow(String windowName) {
		assertThat(getAddAgentPage().keepTheDefaultSettingsInWindow(windowName), Matchers.equalTo(true));
		getAddAgentPage().clickNextButton();
	}

	@When("filling '$text' {email|emails} in '$windowName' window")
	public void fillEmails(String text, String windowName) {
		if (windowName.equals("receive screenshot proof")) {
			getAddAgentPage().fillScreenshotEmail(text);
		} else {
			getAddAgentPage().fillWarningEmail(text);
			getAddAgentPage().fillCriticalEmail(text);
			getAddAgentPage().fillLogDigestEmail(text);
		}
		getAddAgentPage().clickNextButton();
	}

	@Then("system should be protected successfully")
	public void systemShouldBeProtected() throws InterruptedException {
		assertThat(getAddAgentPage().agentShoudBeCreated(), Matchers.equalTo(true));
		getAddAgentPage().clickContinueButton();
		assertThat(getAddAgentPage().agentBlockShouldBeDisplay(), Matchers.equalTo(true));
		assertThat(getAddAgentPage().stateHelperCase(), Matchers.equalTo(true));
	}

	@When("choosing to encrypte the system in 'encrypt the systme(s)' window")
	public void chooseEncrypt() {
		assertThat(getGenericPage().waitElementToBeVisible("encrypt_the_systme(s)"), Matchers.equalTo(true));
		getAddAgentPage().clickOnElement("EncryptYes");
	}

	@When("accepting agent encryption agrement")
	public void acceptEncryptionAgrement() {
		getGenericPage().clickOnElement("IAgreeButton");
	}

}
