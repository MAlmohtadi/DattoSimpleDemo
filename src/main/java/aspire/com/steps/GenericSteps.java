package aspire.com.steps;

import java.io.IOException;
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
	public void deleteFiles(String number, String volumesName, String specialCharacter) {

		getGenericPage().deleteFiles("Test", "E");
		getGenericPage().deleteFiles("Test", "H");
		getGenericPage().deleteFiles("Test", "I");
	}

	@When("I delete the $number files in each backed up volume")
	public void deleteFilesAndTakeBackup(String number) {

		getGenericPage().deleteFilesAndTakeBackup(number);

	}

	@Given("I click on '$element'")
	@When("I click on '$element'")
	@Then("I click on '$element'")
	public void clickOnElement(String element) {
		getGenericPage().clickOnElement(element);

	}

	@When("I wait '$element' to be visible")
	public void waitElementToBeVisibile(String element) {
		getGenericPage().waitElementToBeVisible(element);

	}

	@When("I wait '$name' image to be visible")
	public void waitImageToBeVisible(String name) throws FindFailed {
	getGenericPage().waitImageToBeVisible(name);
	}

	@When("I enter a '$text' inside $element")
	public void waitImageToBeVisible(String text, String element) throws FindFailed {
		getGenericPage().enterTextInElement(text, element);
	}
}
