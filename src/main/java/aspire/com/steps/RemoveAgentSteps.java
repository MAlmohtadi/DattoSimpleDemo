package aspire.com.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;

public class RemoveAgentSteps extends BaseSteps {

	public RemoveAgentSteps() {
		super();
	}

	public RemoveAgentSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
	}

	@When("I remove system from Datto appliance")
	@Composite(steps = { "And I wait 'Remove Agent' image to be visible", "And I select 'Remove Agent'",
			"And I wait 'RecoverySection' to be visible", "And I click on 'RemoveRestore'",
			"And I enter a 'DeleteTextConfirm' inside RemoveAgentConfirm", "And I click on 'RemoveAgentDelete'" })
	public void removeSystemFromDattoAppliance() throws FindFailed, IOException {
		// getRemoveAgentPage().removeSystemFromDattoAppliance();

	}

}
