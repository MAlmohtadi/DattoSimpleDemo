package aspire.com.steps;

import java.io.IOException;

import org.jbehave.core.annotations.Given;

import aspire.com.pages.*;
import cucumber.api.java.Before;

public class LoginSteps extends BaseSteps {

	public LoginSteps() {
		super();
	}

	public LoginSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
	}

	@Given("I login to the Datto")
	public void login() throws IOException {
		getloginPage().login();
	}

}
