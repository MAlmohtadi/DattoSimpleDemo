package aspire.com.steps;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;
import cucumber.api.java.cs.Ale;
import jo.aspire.generic.StateHelper;

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

	@When("Selecting '$element' from system backup wizard")
	public void selectElementFromSystemBackupWizard(String element) {
		getAddAgentPage().selectElementFromSystemBackupWizard(element);
	}

	@When("Filling '$text' Address in 'Hostname'")
	public void fillTextInHostName(String text) {
		assertThat(getAddAgentPage().fillTextInHostName(text), Matchers.equalTo(true));
	}

	@When("Keeping the default settings in '$windowName' window")
	public void keepTheDefaultSettingsInWindow(String windowName) {
		assertThat(getAddAgentPage().keepTheDefaultSettingsInWindow(windowName), Matchers.equalTo(true));
	}

	@When("Filling '$text' {email|emails} in '$windowName' window")
	public void fillEmails(String text, String windowName) {
		getAddAgentPage().fillEmails(text, windowName);
	}

	@Then("system should be protected successfully")
	public void systemShouldBeProtected() {
		assertThat(getAddAgentPage().systemShouldBeProtected(), Matchers.equalTo(true));
	}

	@When("Choosing to encrypte the system in 'encrypt the systme(s)' window")
	public void chooseEncrypt() {
		assertThat(getGenericPage().waitElementToBeVisible("encrypt_the_systme(s)"), Matchers.equalTo(true));
		getAddAgentPage().clickOnElement("EncryptYes");
	}

	@When("Accepting agent encryption agrement")
	public void acceptEncryptionAgrement() {
		getGenericPage().clickOnElement("IAgreeButton");
	}

}
