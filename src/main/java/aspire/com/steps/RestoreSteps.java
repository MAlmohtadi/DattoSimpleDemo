package aspire.com.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;
import jcifs.smb.SmbException;

public class RestoreSteps extends BaseSteps {

	public RestoreSteps() {
		super();
	}

	public RestoreSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
	}

	@When("I perform file restore of $to timestamp")
	public void performRestore(String to) {

		getRestorePage().performRestore();
	}

	@Then("All files should be restored for '$names' volumes")
	@Alias("All files should be restored for '<names>' volumes")
	@Composite(steps = { "Then I verify retrieved 1 file$specialCharacter from '<names>' volumes" })
	public void verifyFilesRestored(String names) throws MalformedURLException, SmbException {
		// String[] volumes = names.split(",");
		// for (int i = 0; i < volumes.length; i++) {
		// assertThat(getRestorePage().checkIfFileShared(),
		// Matchers.equalTo(true));
		// }

	}

	@When("I verify retrieved $number file$specialCharacter from '$volumesName' volumes")
	@Then("I verify retrieved $number file$specialCharacter from '$volumesName' volumes")
	public void verifyAFileRestored(String number, String specialCharacter, String volumesName)
			throws MalformedURLException, SmbException {

		assertThat(getRestorePage().verifyRestoredFiles(number, volumesName), Matchers.equalTo(true));
	}

	@When("I perform a file restore for 1 file from each backed up volume of specific timestamp.")
	public void performRestoreOfSpecificTimestamp() {
		getRestorePage().performRestore();
	}

}
