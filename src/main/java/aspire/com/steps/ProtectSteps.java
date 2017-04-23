package aspire.com.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;

public class ProtectSteps extends BaseSteps {

	public ProtectSteps() {
		super();
	}

	public ProtectSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
	}

	@Given("System is protected as not encrypted")
	@Composite(steps = { "Given I login to the Datto", "When I click on 'Protect'" })
	public void systemIsProtected() throws IOException, FindFailed {

	}

	@Given("System is protected as encrypted")
	@Composite(steps = { "Given I login to the Datto", "When I click on 'Protect'" })
	public void systemIsProtectedAsEncrypted() throws IOException, FindFailed {

	}

	@When("The system is protected")
	@Then("The system is protected")
	@Composite(steps = { "When I wait 'AgentCreated' to be visible", "When I click on 'Continue'",
			"When I wait 'ProtectedSystemsHeader' to be visible", "When ProtectedSystemsHeader should be displayed" })
	public void checkSystemIsProteced() throws FindFailed, IOException {
		// getProtectPage().checkSystemIsCreatedAndProtected();
	}

	@When("I take a backup")
	public void takeBackup() throws IOException, FindFailed {
		getProtectPage().takeBackup();
	}

	@When("backup should be completed successfully")
	@Then("backup should be completed successfully")
	public void verifyBuckupFunctionality() throws IOException, FindFailed {
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@Then("System should be backed up")
	public void systemIsBackedup() throws FindFailed, UnknownHostException {

		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@Given("Backup is available for multiple volumes")
	public void BackupIsAvailable() throws IOException, FindFailed {

	}

	@When("I proceed to take one backup")
	@Then("I proceed to take one backup")
	public void takeMultipleBackups() throws FindFailed, IOException {
		getProtectPage().takeBackup();
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));

	}

	@Given("There are $number text files in '$nameOfvolumes' volumes")
	public void createFilesAndTakeBackup(String number, String nameOfvolumes) throws IOException, FindFailed {
		getProtectPage().createTextFileRemotly(number, nameOfvolumes);
		getProtectPage().takeBackup();
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@When("$element should be displayed")
	public void isElementDisplayed(String element) {
		assertThat(getGenericPage().isElementDisplayed(element), Matchers.equalTo(true));
	}

}
