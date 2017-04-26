Meta:
@Not_Encrypted
Scenario: 004-Perform a file restore of any desired timestamp and retrieve 10 files from each backed up volume. 

Given User is logged in to Datto App
And 10 new 'Test.txt' files are added in '<NameOfVolumesSeperatedByComma>' volumes
And A backup is taken
When Deleting 10 'Test.txt' files from '<NameOfVolumesSeperatedByComma>' volumes
And Navigating to 'Restore' page
And Choosing a 'system' to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a '<recoveryPoint>' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And 10 file is retrieved from '<NameOfVolumesSeperatedByComma>' volumes



And There are <number> text files in '<NameOfVolumesSeperatedByComma>' volumes
When I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
And backup should be completed successfully
And I delete <number> file/files in <NameOfVolumesSeperatedByComma> volumes
And I click on 'RestoreMenu'
And I wait 'RemoveRestore' to be visible
And I click on 'RemoveRestore'
And I wait 'ManageRestore' to be invisible
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|
|H, I|10|