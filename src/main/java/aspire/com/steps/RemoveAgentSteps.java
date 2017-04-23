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
	@Composite(steps = { "When I wait 'Remove Agent' image to be visible", "When I select 'Remove Agent'",
			"When I wait 'RecoverySection' to be visible", "When I click on 'RemoveRestore'",
			"When I enter a 'DeleteTextConfirm' inside RemoveAgentConfirm", "When I click on 'RemoveAgentDelete'" })
	public void removeSystemFromDattoAppliance() throws FindFailed, IOException {
		// getRemoveAgentPage().removeSystemFromDattoAppliance();

	}

}
