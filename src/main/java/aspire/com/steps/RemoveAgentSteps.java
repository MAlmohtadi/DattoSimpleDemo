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

	@When("Inserting '$text' text in the '$element' field")
	public void removeAgent(String text, String element) {
		getRemoveAgentPage().removeAgent(text);
	}

}
