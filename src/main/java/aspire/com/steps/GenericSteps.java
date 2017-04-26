package aspire.com.steps;

import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.*;
import org.sikuli.script.FindFailed;
import aspire.com.pages.*;
import cucumber.api.java.Before;

public class GenericSteps extends BaseSteps {

	public GenericSteps() {
		super();
	}

	public GenericSteps(PageFactory pageFactory) {
		super(pageFactory);
	}

	@Before
	public void beforeCucmberScenario() {
		System.out.println("ttt");
	}

	@When("Clicking '$element'")
	public void clickOnElement(String element) {
		getGenericPage().clickOnElement(element);

	}

	@When("Clicking '$element' to $word")
	public void clickOnElementWithExplain(String element, String word) {
		getGenericPage().clickOnElement(element);

	}
	// @When("I wait '$element' to be visible")
	// @Then("I wait '$element' to be visible")
	// public void waitElementToBeVisibile(String element) {
	// assertThat(getGenericPage().waitElementToBeVisible(element),
	// Matchers.equalTo(true));
	//
	// }
	//
	// @When("I wait '$element' to be invisible")
	// public void waitElementToBeInvisibile(String element) {
	// assertThat(getGenericPage().waitElementToBeInvisible(element),
	// Matchers.equalTo(true));
	//
	// }
	//
	// @When("I wait '$name' image to be visible")
	// public void waitImageToBeVisible(String name) throws FindFailed {
	// assertThat(getGenericPage().waitImageToBeVisible(name),
	// Matchers.equalTo(true));
	// }

	// @When("I enter '$text' inside $element")
	// public void waitImageToBeVisible(String text, String element) throws
	// FindFailed {
	// getGenericPage().enterTextInElement(text, element);
	// }

	@When("$element should be displayed")
	@Then("$element should be displayed")
	public void isElementDisplayed(String element) {
		assertThat(getGenericPage().isElementDisplayed(element), Matchers.equalTo(true));
	}

	@Then("'$element' Url should display")
	public void urlShouldDisplay(String element) {
		assertThat(getGenericPage().urlShouldDisplay(element), Matchers.equalTo(true));
	}

	// ############
	@When("Navigating to '$name' page")
	public void navigateUsingClick(String name) throws FindFailed {
		getGenericPage().navigateUsingClick(name);
	}
}
