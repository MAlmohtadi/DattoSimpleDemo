Meta:
@Encrypted
Scenario: 009-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.


Given User is logged in to Datto App
And There is a protected system
And Delete 'Test.txt' file from 'NameOfVolumesSeperatedByComma' volumes
When Navigating to 'Restore' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a '<recoveryPoint>' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
And Filling 'ValidPassphrase' in 'Verify Passphrase' popup
Then 'Samba Share' Url should display
And File is retrieved from '<NameOfVolumesSeperatedByComma>' volumes






And I wait 'PassphraseTextBox' to be visible
And I enter 'ValidPassphrase' inside PassphraseTextBox
And I click on 'VerifyPhraseButton'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|
|H, I|1|