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
	}

}