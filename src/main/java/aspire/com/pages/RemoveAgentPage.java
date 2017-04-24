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
public class RemoveAgentPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public RemoveAgentPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	/**
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");
	private final int CONST_WAIT_LOWER_VALUE = 30;

	public void removeSystemFromDattoAppliance() {
		// TODO Auto-generated method stub
		
	}

	// /**
	// * This method is used to remove existed system from DATTO appliance
	// whether
	// * if it is encrypted or not and with his restored files.
	// *
	// * @throws FindFailed
	// * @throws IOException
	// */
	// public void removeSystemFromDattoAppliance() throws FindFailed,
	// IOException {
	//
	// try {
	// screen.wait(imgsPath + "Remove Agent.png", 10);
	// screen.click(imgsPath + "Remove Agent.png");
	// } catch (Exception e) {
	// return;
	// }
	//
	// sleepTime(2000);
	// try {
	// waitElementToBeVisible("RecoverySection", 5);
	// clickOnElement("RemoveRestore");
	// sleepTime(5000);
	// waitElementToBeVisible("ForceUnmount", 10);
	// clickOnElement("ForceUnmount");
	// } catch (Exception e) {
	//
	// System.out.println("there is no restored filed to be remove");
	// }
	// enterTextInElement("delete my local and cloud data",
	// "RemoveAgentConfirm");
	// clickOnElement("RemoveAgentDelete");
	// }

}