package aspire.com.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import jo.aspire.web.automationUtil.BrowserAlertHelper;

import java.io.IOException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class ConfigureAgentSettingsPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public ConfigureAgentSettingsPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");

	/**
	 * Exclude a volume from Datto appliance based on volume name.
	 * 
	 * @param volumeName:
	 *            name of volume to be excluded.
	 */
	public void excludeVolumes(String volumeName) {

		waitElementToBeVisible(volumeName, CONST_WAIT_LOWER_VALUE);
		sleepTime(2000);
		if (!getElementByCssSelector(volumeName).isSelected()) {
			clickOnElement(volumeName);
		}
		sleepTime(3000);
		// if (volumeName.equalsIgnoreCase("c")) {
		// if
		// (!getElementByCssSelector("ExecludVolumeCheckboxForC").isSelected())
		// {
		// clickOnElement("ExecludVolumeCheckboxForC");
		// }
		// } else if (volumeName.equalsIgnoreCase("E")) {
		// if
		// (!getElementByCssSelector("ExecludVolumeCheckboxForE").isSelected())
		// {
		// clickOnElement("ExecludVolumeCheckboxForE");
		// }
		// } else if (volumeName.equalsIgnoreCase("h")) {
		// if
		// (!getElementByCssSelector("ExecludVolumeCheckboxForH").isSelected())
		// {
		// clickOnElement("ExecludVolumeCheckboxForH");
		// }
		// } else if (volumeName.equalsIgnoreCase("I")) {
		// if
		// (!getElementByCssSelector("ExecludVolumeCheckboxForI").isSelected())
		// {
		// clickOnElement("ExecludVolumeCheckboxForI");
		// }
		// }
		// if (isExecluded) {
		// sleepTime(3000);
		// clickOnElement("PopupConfirmButton");
		// }
	}

	/**
	 * Include a volume from Datto appliance based on volume name.
	 * 
	 * @param volumeName:
	 *            name of volume to be included.
	 */
	public void includeTheExcludedVolumes(String volumeName) throws FindFailed, IOException {
		waitElementToBeVisible(volumeName, CONST_WAIT_LOWER_VALUE);
		sleepTime(2000);
		if (getElementByCssSelector(volumeName).isSelected()) {
			clickOnElement(volumeName);
		}
		sleepTime(3000);
		// waitElementToBeVisible("ExecludVolumeCheckboxForH",
		// CONST_WAIT_LOWER_VALUE);
		// sleepTime(2000);
		// if (volumeName.equalsIgnoreCase("c")) {
		// if
		// (getElementByCssSelector("ExecludVolumeCheckboxForC").isSelected()) {
		// clickOnElement("ExecludVolumeCheckboxForC");
		//
		// }
		// } else if (volumeName.equalsIgnoreCase("E")) {
		// if
		// (getElementByCssSelector("ExecludVolumeCheckboxForE").isSelected()) {
		// clickOnElement("ExecludVolumeCheckboxForE");
		//
		// }
		// } else if (volumeName.equalsIgnoreCase("h")) {
		// if
		// (getElementByCssSelector("ExecludVolumeCheckboxForH").isSelected()) {
		// clickOnElement("ExecludVolumeCheckboxForH");
		//
		// }
		// } else if (volumeName.equalsIgnoreCase("I")) {
		// if
		// (getElementByCssSelector("ExecludVolumeCheckboxForI").isSelected()) {
		// clickOnElement("ExecludVolumeCheckboxForI");
		//
		// }
		// }
		// sleepTime(3000);
	}

}