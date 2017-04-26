package aspire.com.pages;

import org.apache.commons.io.FileUtils;
import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.CommandLine;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhq.selenium.fluent.FluentWebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import com.google.inject.Key;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import jo.aspire.automation.logger.EnvirommentManager;
import jo.aspire.generic.StateHelper;
import jo.aspire.web.automationUtil.BrowserAlertHelper;
import junit.framework.Assert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.openqa.selenium.By.cssSelector;
import static org.seleniumhq.selenium.fluent.Period.secs;

/**
 * Page object defining the home page
 */
public class GenericPage extends FluentWebDriverPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public GenericPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public static boolean isExecluded = false;
	String imgsPath = System.getProperty("user.dir") + File.separator + "imgs" + File.separator;
	/**
	 * Default Selector within the class
	 */
	public By Version = cssSelector("td.mh22-text a");
	public final int CONST_WAIT_LOWER_VALUE = 30;
	public final int CONST_WAIT_HIGHER_VALUE = 90;

	/**
	 * Get value of the key from properties.
	 * 
	 * @param keyInProperties:
	 *            name of key.
	 * @return String.
	 */
	public String getProperty(String keyInProperties) {
		return EnvirommentManager.getInstance().getProperty(keyInProperties);
	}

	/**
	 * Wait an element to be visible on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 * @param timeInSeconds:
	 *            time to wait.
	 */
	public void waitElementToBeVisible(String elementName, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(getProperty(elementName))));

	}

	/**
	 * Wait an element to be visible on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 */
	public boolean waitElementToBeVisible(String elementName) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), CONST_WAIT_HIGHER_VALUE);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(getProperty(elementName))));
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}

		return true;
	}

	/**
	 * Wait an element to be invisible on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 */
	public boolean waitElementToBeInvisible(String elementName) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), CONST_WAIT_LOWER_VALUE);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(getProperty(elementName))));
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}

		return true;
	}

	/**
	 * Wait an element to be able to click on it for a period of time.
	 * 
	 * @param elementName:
	 *            name of element.
	 * @param timeInSeconds:
	 *            time to wait.
	 */
	public void waitElementToBeClickable(String elementName, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(getDriverProvider().get(), timeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(getProperty(elementName))));
	}

	/**
	 * Get an element by Css selector then return it as WebElement
	 * 
	 * @param elementName:
	 *            name of element to be find.
	 * @return WebElement.
	 */
	public WebElement getElementByCssSelector(String elementName) {
		return findElement(By.cssSelector(getProperty(elementName)));
	}

	/**
	 * Enter a text in a text field element.
	 * 
	 * @param text:
	 *            text to be entered.
	 * @param elementName:
	 *            name of the element to be enter text in it.
	 */
	public void enterTextInElement(String text, String elementName) {
		waitElementToBeVisible(elementName, CONST_WAIT_LOWER_VALUE);
		getElementByCssSelector(elementName).sendKeys(text);
	}

	/**
	 * Click on element by its CSS selector.
	 * 
	 * @param elementName:
	 *            element name to get it's value from properties file.
	 */
	public void clickOnElement(String elementName) {
		elementName = elementName.replace(" ", "").trim();
		waitElementToBeClickable(elementName, CONST_WAIT_HIGHER_VALUE);
		getElementByCssSelector(elementName).click();
	}

	/**
	 * this method is used in special cases to pause the running for a period of
	 * time.
	 * 
	 * @param seconds:
	 *            number of seconds for sleep.
	 */
	public void sleepTime(int seconds) {
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Check if element displays by it's CSS selector.
	 * 
	 * @param nameOfElement:
	 *            name of the element
	 * @return Boolean.
	 */
	public boolean isElementDisplayed(String nameOfElement) {
		return getElementByCssSelector("ProtectedSystemsHeader").isDisplayed();
	}

	/**
	 * this method is used to click on image using sikulix.
	 * 
	 * @param imageName:
	 *            image name.
	 * @throws FindFailed.
	 */
	public void selectElement(String imageName) throws FindFailed {

		Screen screen = new Screen();
		screen.wait(imgsPath + imageName + ".png", CONST_WAIT_LOWER_VALUE);
		screen.click(imgsPath + imageName + ".png");
	}

	/**
	 * wait image to be visible.
	 * 
	 * @param imageName:
	 *            image name that already saved in imgs folder.
	 * @return boolean
	 */
	public boolean waitImageToBeVisible(String imageName) {
		Screen screen = new Screen();
		try {
			screen.wait(imgsPath + imageName + ".png", CONST_WAIT_LOWER_VALUE);
		} catch (FindFailed e) {

			System.err.println(e);
			return false;
		}
		return true;
	}

	// ##################
	public void navigateUsingClick(String name) throws FindFailed {
		selectElement(name);
	}

	public Boolean urlShouldDisplay(String element) {
		element = element.replace(" ", "_");
		return waitElementToBeVisible(element);
	}
}