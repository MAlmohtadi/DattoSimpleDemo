package aspire.com.steps;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.sikuli.script.FindFailed;

import aspire.com.pages.PageFactory;
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

	@When("clicking '$element'")
	public void clickOnElement(String element) {
		getGenericPage().clickOnElement(element);

	}

	@When("clicking '$element' to $word")
	public void clickOnElementWithExplain(String element, String word) {
		getGenericPage().clickOnElement(element);

	}

	@Then("'$element' Url should display")
	public void urlShouldDisplay(String element) {
		element = element.replace(" ", "_");
		assertThat(getGenericPage().waitElementToBeVisible(element), Matchers.equalTo(true));
	}

	@When("navigating to '$name' page")
	public void navigateUsingClick(String name) throws FindFailed {
		getGenericPage().selectElement(name);
	}

	@When("filling '$text' in '$element' {field|popup}")
	public void fillTextInElement(String text, String element) {
		getGenericPage().fillTextInElement(text, element);
		if (element.contains("Repeat")) {
			getAddAgentPage().clickNextButton();
		}
		if (element.contains("Verify")) {
			getAddAgentPage().clickVerifyButton();
		}

	}

	@When("deleting $number '$fileName' files from '$volumesName' volumes")
	public void deleteTextFiles(String number, String fileName, String volumesName) {
		getGenericPage().deleteTextFiles(number, fileName, volumesName);
	}

	@Given("delete '$fileName' file from '$volumesName' volumes")
	@When("deleting '$fileName' file from '$volumesName' volumes")
	public void deleteTextFiles(String fileName, String volumesName) {
		getGenericPage().deleteTextFiles("1", fileName, volumesName);
	}

	@Given("a new $fileName file is added in '$volumesName' volumes")
	@When("a new $fileName file is added in '$volumesName' volumes")
	public void addFile(String fileName, String volumesName) {
		getGenericPage().createTextFile("1", fileName, volumesName);
	}

}
