package aspire.com.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.PageFactory;
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

	@Given("there is a protected system")
	public void checkIfSystemProtected() {
		getProtectPage().clickProtectButton();
		assertThat(getProtectPage().checkIfSystemProtected(), Matchers.equalTo(true));
	}

	@When("taking one backup")
	public void takeOneBackup() throws FindFailed {
		assertThat(getProtectPage().takeOneBackup(), Matchers.equalTo(true));
	}

	@Then("backup should be completed successfully")
	public void verifyBuckupFunctionality() throws IOException, FindFailed {
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@Given("$number new '$fileName' files are added in '$volumesName' volumes")
	public void addFiles(String number, String fileName, String volumesName) {
		getProtectPage().createTextFile(number, fileName, volumesName);
	}

	@Given("a backup is taken")
	@When("a backup is taken")
	public void backupIsTaken() throws FindFailed {
		getGenericPage().clickOnElement("PROTECT");
		assertThat(getProtectPage().takeOneBackup(), Matchers.equalTo(true));
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}
}
