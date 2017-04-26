package aspire.com.pages;

import org.apache.commons.io.FileUtils;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.os.CommandLine;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import jo.aspire.web.automationUtil.BrowserAlertHelper;
import junit.framework.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import static org.openqa.selenium.By.cssSelector;

/**
 * Page object defining the home page
 */
public class ProtectPage extends GenericPage {
	public Connection con;
	BrowserAlertHelper test = new BrowserAlertHelper();

	public ProtectPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public final int CONST_WAIT_SPECIAL_USAGE = 400;
	/**
	 * Default Selector within the class
	 */
	private By Version = cssSelector("td.mh22-text a");

	/**
	 * This method used to check if the back up finished.
	 * 
	 * @return Boolean.
	 * @throws FindFailed
	 */
	public boolean verifyBuckupFunctionality() throws FindFailed {
		Screen screen = new Screen();
		screen.wait(imgsPath + "Last Successful backup.png", CONST_WAIT_SPECIAL_USAGE);
		return screen.exists(imgsPath + "Last Successful backup.png") != null;
	}

	public void createTextFile(String fileNumber, String nameOfFile, String volumesName) {
		String ipAddress = getProperty("Windows").toString();
		int numberOfFiles = Integer.parseInt(fileNumber);

		String[] volumesArray = volumesName.split(",");
		if (numberOfFiles != 1) {
			for (int i = 1; i <= numberOfFiles; i++) {
				for (int j = 0; j < volumesArray.length; j++) {
					addFile(ipAddress, volumesArray[j], i + nameOfFile);
				}
			}
		} else {
			for (int j = 0; j < volumesArray.length; j++) {
				addFile(ipAddress, volumesArray[j], nameOfFile);
			}
		}

	}

	/**
	 * Add a file to volumes based on name of the file and name of the volume.
	 * 
	 * @param ipAddress:
	 *            IP To connect to machine.
	 * @param file:
	 *            name of the file to be added.
	 * @param nameOfVolume:
	 *            name of the volume to add the file to it.
	 * 
	 */
	public void addFile(String ipAddress, String nameOfVolume, String file) {
		File f = null;
		try {
			f = new File(new URI("file:////" + ipAddress + "/" + nameOfVolume.trim() + "$/" + file));
			f.createNewFile();
			FileUtils.writeStringToFile(f, loremText());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Get the IP address for this machine.
	 * 
	 * @return String.
	 */
	public String getMyIP() {
		CommandLine commandLine;

		commandLine = new CommandLine("cmd.exe", "/C", "ipconfig");
		commandLine.execute();

		String instancePath = (commandLine.getStdOut()).trim();
		instancePath = instancePath.split("Wireless LAN adapter Wireless Network Connection:")[1]
				.split("Ethernet adapter Local Area Connection:")[0].split("IPv4 Address. . . . . . . . . . . : ")[1]
						.split("Subnet Mask . . . . . . . . . . . :")[0].trim();
		return instancePath;
	}

	/**
	 * lorem text.
	 * 
	 * @return String.
	 */
	public String loremText() {
		return "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.\n" + "Aenean commodo ligula eget dolor.\n"
				+ "Aenean massa.\n"
				+ "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.\n"
				+ "Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem.\n"
				+ "Nulla consequat massa quis enim.\n"
				+ "Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu.\n"
				+ "In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo.\n"
				+ "Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus.\n"
				+ "Vivamus elementum semper nisi. Aenean vulputate eleifend tellus.\n"
				+ "Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.\n"
				+ "Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus.\n"
				+ "Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet.\n"
				+ "Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui.\n"
				+ "Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum.\n"
				+ " Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem.\n "
				+ "Maecenas nec odio et ante tincidunt tempus. Donec vitae sapien ut libero venenatis faucibus.\n"
				+ "Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo.\n"
				+ "Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna.\n"
				+ "Sed consequat, leo eget bibendum sodales, augue velit cursus nunc, quis gravida magna mi a libero.\n"
				+ "Fusce vulputate eleifend sapien. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus.\n"
				+ "Nullam accumsan lorem in dui. Cras ultricies mi eu turpis hendrerit fringilla.\n"
				+ " Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; In ac dui quis mi consectetuer lacinia.\n"
				+ "Nam pretium turpis et arcu. Duis arcu tortor, suscipit eget, imperdiet nec, imperdiet iaculis, ipsum.\n"
				+ "Sed aliquam ultrices mauris. Integer ante arcu, accumsan a, consectetuer eget, posuere ut, mauris.\n"
				+ "Praesent adipiscing. Phasellus ullamcorper ipsum rutrum nunc.\n"
				+ "Nunc nonummy metus. Vestibulum volutpat pretium libero. Cras id dui.\n"
				+ "Aenean ut eros et nisl sagittis vestibulum.\n"
				+ "Nullam nulla eros, ultricies sit amet, nonummy id, imperdiet feugiat, pede. Sed lectus.\n "
				+ "Donec mollis hendrerit risus. Phasellus nec sem in justo pellentesque facilisis.\n"
				+ "Etiam imperdiet imperdiet orci. Nunc nec neque. Phasellus leo dolor, tempus non, auctor et, hendrerit quis, nisi.\n"
				+ "Curabitur ligula sapien, tincidunt non, euismod vitae, posuere imperdiet, leo.\n"
				+ "Maecenas malesuada. Praesent congue erat at massa. Sed cursus turpis vitae tortor.\n"
				+ "Donec posuere vulputate arcu. Phasellus accumsan cursus velit.\n"
				+ "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;";
	}

	/**
	 * Delete files from volumes based on name of the file and name of the
	 * volume.
	 * 
	 * @param nameOfFile:
	 *            name of the file to be deleted.
	 * @param nameOfVolume:
	 *            name of the volume that contains the file.
	 */
	public void deleteTextFiles(String numberOfFiles, String nameOfFile, String nameOfVolume) {
		// String ipAddress =
		// StateHelper.getApplicationState("machineIP").toString();
		String ipAddress = getProperty("Windows");
		String[] volumes = nameOfVolume.split(",");
		int numberOfFilesToBeDeleted = Integer.parseInt(numberOfFiles);
		File file = null;
		if (numberOfFilesToBeDeleted != 1) {
			for (int i = 0; i < volumes.length; i++) {
				for (int j = 1; j <= numberOfFilesToBeDeleted; j++) {
					try {
						file = new File(
								new URI("file:////" + ipAddress + "/" + volumes[i].trim() + "$/" + j + nameOfFile));
						if (FileUtils.deleteQuietly(file)) {
							System.out.println(file.getName() + " is deleted!");
						} else {
							System.out.println("Delete operation is failed.");
							Assert.assertEquals(true, false);
						}
					} catch (Exception e) {
						System.out.println("File Path not exist");
					}
				}
			}
		} else {
			for (int i = 0; i < volumes.length; i++) {
				try {
					file = new File(new URI("file:////" + ipAddress + "/" + volumes[i].trim() + "$/" + nameOfFile));
					if (FileUtils.deleteQuietly(file)) {
						System.out.println(file.getName() + " is deleted!");
					} else {
						System.out.println("Delete operation is failed.");
						Assert.assertEquals(true, false);
					}
				} catch (Exception e) {
					System.out.println("File Path not exist");
				}
			}
		}
	}

	// #############
	public boolean checkIfSystemProtected() {
		clickOnElement("PROTECT");
		return waitElementToBeVisible("ProtectedSystemsHeader");
	}

	public boolean takeOneBackup() throws FindFailed {
		if (waitImageToBeVisible("Start Backup")) {
			selectElement("Start Backup");
			return waitImageToBeVisible("Cancel");
		}
		return false;
	}

}