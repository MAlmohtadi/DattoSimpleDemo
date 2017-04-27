package aspire.com.steps;

import java.io.IOException;

import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.PageFactory;
import cucumber.api.java.Before;

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

	@When("excluding '$name' volume")
	public void excludeVolumes(String name) throws IOException, FindFailed {
		getConfigureAgentSettingsPage().excludeVolumes(name);
	}

	@When("confirming excluding the '$volumeName' volume")
	public void confirmExcluding() {
		getGenericPage().clickOnElement("PopupConfirmExclude");
	}

	@When("including '$name' volume")
	public void includeTheExcludedVolumes(String name) throws IOException, FindFailed {
		getConfigureAgentSettingsPage().includeTheExcludedVolumes(name);
	}
}
