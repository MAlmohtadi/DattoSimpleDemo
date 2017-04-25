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

	@When("I verify retrieved $number file/files from '$volumesName' volumes")
	@Then("I verify retrieved $number file/files from '$volumesName' volumes")
	public void verifyAFileRestored(String number, String volumesName)
			throws MalformedURLException, SmbException {
		assertThat(getRestorePage().verifyRestoredFiles(number, volumesName), Matchers.equalTo(true));
	}


}
