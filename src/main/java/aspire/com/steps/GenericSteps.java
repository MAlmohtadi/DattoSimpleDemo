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

	@Given("A new $fileType file is added in '$volumesName' volumes")
	public void addFile(String fileType, String volumesName) {
		getGenericPage().createTextFileRemotly("1", volumesName);
	}

	@Given("I select '$element'")
	@When("I select '$element'")
	@Then("I select '$element'")
	public void selectElement(String element) throws IOException, FindFailed {

		getGenericPage().selectElement(element);

	}

	@Given("$number text file$specialCharacter is deleted from '$volumesName' volume")
	@When("$number text file$specialCharacter is deleted from '$volumesName' volume")
	public void deleteFiles(String number, String specialCharacter, String volumesName) {

		getGenericPage().deleteTextFiles(number, volumesName);
	}

	@When("I delete the $number files in $nameOfVolumesSeperatedByComma volume")
	public void deleteTextFiles(String number, String nameOfVolumesSeperatedByComma) {

		getGenericPage().deleteTextFiles(number, nameOfVolumesSeperatedByComma);

	}

	@Given("I click on '$element'")
	@When("I click on '$element'")
	@Then("I click on '$element'")
	public void clickOnElement(String element) {
		getGenericPage().clickOnElement(element);

	}

	@When("I wait '$element' to be visible")
	public void waitElementToBeVisibile(String element) {
		assertThat(getGenericPage().waitElementToBeVisible(element), Matchers.equalTo(true));

	}

	@When("I wait '$element' to be invisible")
	public void waitElementToBeInvisibile(String element) {
		assertThat(getGenericPage().waitElementToBeInvisible(element), Matchers.equalTo(true));

	}

	@When("I wait '$name' image to be visible")
	public void waitImageToBeVisible(String name) throws FindFailed {
		assertThat(getGenericPage().waitImageToBeVisible(name), Matchers.equalTo(true));
	}

	@When("I enter '$text' inside $element")
	public void waitImageToBeVisible(String text, String element) throws FindFailed {
		getGenericPage().enterTextInElement(text, element);
	}

	@When("$element should be displayed")
	public void isElementDisplayed(String element) {
		assertThat(getGenericPage().isElementDisplayed(element), Matchers.equalTo(true));
	}
}
