package aspire.com.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.UnknownHostException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
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
	@Given("A new $fileName file is added in '$volumesName' volumes")
	@When("A new $fileName file is added in '$volumesName' volumes")
	public void addFile(String fileName, String volumesName) {
		getProtectPage().createTextFile("1", fileName, volumesName);
	}

	// ##################
	@Given("There is a protected system")
	public void checkIfSystemProtected() {
		assertThat(getProtectPage().checkIfSystemProtected(), Matchers.equalTo(true));
	}

	@When("Taking one backup")
	public void takeOneBackup() throws FindFailed {
		assertThat(getProtectPage().takeOneBackup(), Matchers.equalTo(true));
	}

	@Then("backup should be completed successfully")
	public void verifyBuckupFunctionality() throws IOException, FindFailed {
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@Given("Delete '$fileName' file from '$volumesName' volumes")
	@When("Deleting '$fileName' file from '$volumesName' volumes")
	public void deleteTextFiles(String fileName, String volumesName) {
		getProtectPage().deleteTextFiles("1", fileName, volumesName);
	}

	@Given("$number new '$fileName' files are added in '$volumesName' volumes")
	public void addFiles(String number, String fileName, String volumesName) {
		getProtectPage().createTextFile(number, fileName, volumesName);
	}

	@Given("A backup is taken")
	@When("A backup is taken")
	public void backupIsTaken() throws FindFailed {
		getGenericPage().clickOnElement("PROTECT");
		assertThat(getProtectPage().takeOneBackup(), Matchers.equalTo(true));
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@When("Deleting $number '$fileName' files from '$volumesName' volumes")
	public void deleteTextFiles(String number, String fileName, String volumesName) {
		getProtectPage().deleteTextFiles(number, fileName, volumesName);
	}
}
