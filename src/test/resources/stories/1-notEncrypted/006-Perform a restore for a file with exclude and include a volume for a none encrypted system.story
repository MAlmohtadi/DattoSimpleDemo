Meta:
@Not_Encrypted
Scenario: 006-Before performing backup after protecting system, exclude 1 volume, perform a file restore of last timestamp.  Proceed include all volumes and retrieve 1 file from a backed up volume. 

Given User is logged in to Datto App
And There is a protected system
And A new Test1.txt file is added in '<volumes1>' volumes
When Navigating to 'Configure Agent Settings' page
And Excluding '<volumeToBeExcluded>' volume
And Confirming excluding the '<volumeToBeExcluded>' volume
And Navigating to 'Protect' page
And A backup is taken
And A new Test2.txt file is added in '<volumes2>' volumes
And Navigating to 'Configure Agent Settings' page
And Including '<volumeToBeExcluded>' volume
And Navigating to 'Protect' page
And A backup is taken
And Deleting 'Test2.txt' file from '<volumes2>' volumes
And Navigating to 'Restore' page
And Choosing a system '<system>' to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a '<recoveryPoint>' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And File is retrieved from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|volumes1|volumes2|volumeToBeExcluded|
|H,I|E,H,I|E|





And I click on 'RestoreMenu'
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<firstRetriveForVolumes>' volumes
When I click on 'Protect'
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I include the excluded '<volumeName>' volume
And I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
And backup should be completed successfully
And I click on 'RestoreMenu'
And I wait 'RemoveRestore' to be visible
And I click on 'RemoveRestore'
And I wait 'ManageRestore' to be invisible
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<firstRetriveForVolumes>' volumes


Examples:
|volumeName|firstRetriveForVolumes|secondRetriveForVolumes|volumes|number|
|E|H, I|E, H, I|E, H, I|1|