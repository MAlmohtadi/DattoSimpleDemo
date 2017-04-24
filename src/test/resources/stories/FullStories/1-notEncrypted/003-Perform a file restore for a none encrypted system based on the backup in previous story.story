Meta:
@Not_Encrypted
Scenario: 003-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.

Given I login to the Datto
And I click on 'Protect'
And Backup is available for multiple volumes
And <number> text file/files deleted from '<NameOfVolumesSeperatedByComma>' volumes
When I click on 'RestoreMenu'
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
|H, I|1|