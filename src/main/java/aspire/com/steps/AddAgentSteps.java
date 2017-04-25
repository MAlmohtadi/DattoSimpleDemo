package aspire.com.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Composite;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.*;
import cucumber.api.java.Before;
import cucumber.api.java.cs.Ale;
import jo.aspire.generic.StateHelper;

public class AddAgentSteps extends BaseSteps {

	public AddAgentSteps() {
		super();
	}

	public AddAgentSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
		System.out.println("ttt");
	}

}
