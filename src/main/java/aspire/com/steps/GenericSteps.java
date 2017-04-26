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

	@Then("'$element' Url should display")
	public void urlShouldDisplay(String element) {
		element = element.replace(" ", "_");
		assertThat(getGenericPage().waitElementToBeVisible(element), Matchers.equalTo(true));
	}

	@When("Navigating to '$name' page")
	public void navigateUsingClick(String name) throws FindFailed {
		getGenericPage().selectElement(name);
	}

	@When("Filling '$text' in '$element' {field|popup}")
	public void fillTextInElement(String text, String element) {
		getGenericPage().fillTextInElement(text, element);
	}

	@When("Deleting $number '$fileName' files from '$volumesName' volumes")
	public void deleteTextFiles(String number, String fileName, String volumesName) {
		getGenericPage().deleteTextFiles(number, fileName, volumesName);
	}

	@Given("Delete '$fileName' file from '$volumesName' volumes")
	@When("Deleting '$fileName' file from '$volumesName' volumes")
	public void deleteTextFiles(String fileName, String volumesName) {
		getGenericPage().deleteTextFiles("1", fileName, volumesName);
	}

	@Given("A new $fileName file is added in '$volumesName' volumes")
	@When("A new $fileName file is added in '$volumesName' volumes")
	public void addFile(String fileName, String volumesName) {
		getGenericPage().createTextFile("1", fileName, volumesName);
	}

}
