package aspire.com.steps;

import org.jbehave.core.annotations.When;

import aspire.com.pages.PageFactory;
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

	@When("inserting '$text' text in the '$element' field")
	public void removeAgent(String text, String element) {
		getRemoveAgentPage().removeAgent(text,element);
	}

}
