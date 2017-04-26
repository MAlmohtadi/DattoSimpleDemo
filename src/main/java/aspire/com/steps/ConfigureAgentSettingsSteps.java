package aspire.com.steps;

import java.io.IOException;
import java.net.UnknownHostException;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class ConfigureAgentSettingsSteps extends BaseSteps {

	public ConfigureAgentSettingsSteps() {
		super();
	}

	public ConfigureAgentSettingsSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
	}

	@When("I do not exclude any volume")
	public void doNotExcludeAnyVolumes() throws FindFailed, UnknownHostException {

	}

	@When("I include the excluded '$nameOfVolume' volume")
	public void includeTheExcludedVolumes(String nameOfVolume) throws IOException, FindFailed {
		getConfigureAgentSettingsPage().includeTheExcludedVolumes(nameOfVolume);
	}

	// ############

	@When("Excluding '$name' volume")
	public void excludeVolumes(String name) throws IOException, FindFailed {
		getConfigureAgentSettingsPage().excludeVolumes(name);
	}

	@When("Confirming excluding the '$volumeName' volume")
	public void confirmExcluding() {
		getGenericPage().clickOnElement("PopupConfirmExclude");
	}
}
