Meta:
@Not_Encrypted
Scenario: 003-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'RESTORE' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a 'last' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And File is retrieved from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|system|recoveryType|NameOfVolumesSeperatedByComma|
|DATTO-ALMOHTAD|File Restore|H,I|






And I click on 'Protect'
And Backup is available for multiple volumes
And <number> text file/files deleted from '<NameOfVolumesSeperatedByComma>' volumes
When I click on 'RestoreMenu'
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'Start File Restore'
And I click on 'Mount'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|recoveryType|system|recoveryPoint|
|H, I|1|File Restore|DATTO-MALMOHTAD|Last|