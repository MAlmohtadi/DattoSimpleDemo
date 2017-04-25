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

	@Given("backup should be completed successfully")
	@When("backup should be completed successfully")
	@Then("backup should be completed successfully")
	public void verifyBuckupFunctionality() throws IOException, FindFailed {
		assertThat(getProtectPage().verifyBuckupFunctionality(), Matchers.equalTo(true));
	}

	@Given("Backup is available for multiple volumes")
	public void BackupIsAvailable() throws IOException, FindFailed {

	}

	@Given("There are $number text files in '$nameOfvolumes' volumes")
	public void createFilesAndTakeBackup(String number, String nameOfvolumes) throws IOException, FindFailed {
		getProtectPage().createTextFile(number, nameOfvolumes);
	}

	@Given("A new $fileType file is added in '$volumesName' volumes")
	public void addFile(String fileType, String volumesName) {
		getProtectPage().createTextFile("1", volumesName);
	}

	@When("I delete $number file/files in $nameOfVolumesSeperatedByComma volumes")
	public void deleteTextFiles(String number, String nameOfVolumesSeperatedByComma) {
		getProtectPage().deleteTextFiles(number, nameOfVolumesSeperatedByComma);
	}

	@Given("$number text file/files deleted from '$volumesName' volumes")
	@When("$number text file/files deleted from '$volumesName' volumes")
	public void deleteFiles(String number, String volumesName) {
		getProtectPage().deleteTextFiles(number, volumesName);
	}

}
