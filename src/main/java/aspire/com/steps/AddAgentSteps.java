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

	@When("I re-protect the system as not encrypted for $osType")
	@Alias("I re-protect the system as not encrypted for <osType>")
	@Composite(steps = { "When I wait 'AddBasedSystem' to be visible", "When I click on 'AddBasedSystem'",
			"When I click on 'IpAddressOrHost'", "When I enter '<osType>' inside IpAddressTextBox",
			"When I click on 'NextButton'", "When I wait 'nextIcon' to be visible", "When I click on 'NextButton'",
			"When I wait 'LocalBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'CloudBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'RetentionBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'EmailAddress' to be visible", "When I enter 'ValidEmail' inside EmailAddress",
			"When I click on 'NextButton'", "When I wait 'AlerAndReports' to be visible",
			"When I enter 'ValidEmail' inside CriticalEmail", "When I click on 'NextButton'",
			"When I wait 'EncryptSection' to be visible", "When I click on 'NextButton'" })
	public void reprotectNoneEncryptedSystem(@Named("osType") String osType) throws FindFailed, IOException {
		StateHelper.setApplicationState("machineIP", getGenericPage().getProperty(osType));
	}

	@When("I re-protect the system as encrypted for $osType")
	@Alias("I re-protect the system as encrypted for <osType>")
	@Composite(steps = { "When I wait 'AddBasedSystem' to be visible", "When I click on 'AddBasedSystem'",
			"When I click on 'IpAddressOrHost'", "When I enter '<osType>' inside IpAddressTextBox",
			"When I click on 'NextButton'", "When I wait 'nextIcon' to be visible", "When I click on 'NextButton'",
			"When I wait 'LocalBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'CloudBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'RetentionBackups' to be visible", "When I click on 'NextButton'",
			"When I wait 'EmailAddress' to be visible", "When I enter 'ValidEmail' inside EmailAddress",
			"When I click on 'NextButton'", "When I wait 'AlerAndReports' to be visible",
			"When I enter 'ValidEmail' inside CriticalEmail", "When I click on 'NextButton'",
			"When I wait 'EncryptSection' to be visible", "When I click on 'EncryptYes'",
			"When I click on 'IAgreeButton'", "When I wait 'EnterPassphrase' to be visible",
			"When I enter 'ValidPassphrase' inside EnterPassphrase",
			"When I enter 'RepeatPassphrase' inside EnterPassphrase", "When I click on 'NextButton'" })
	public void reprotectEncryptedSystem(@Named("osType") String osType) throws FindFailed, IOException {
		StateHelper.setApplicationState("machineIP", getGenericPage().getProperty(osType));
	}
}
