Meta:
@Not_Encrypted
Scenario: 006.1-Before performing backup after protecting system, exclude 1 volume, perform a file restore of last timestamp.  Proceed include all volumes and retrieve 1 file from a backed up volume. 

Given I login to the Datto
And I click on 'Protect'
And A new text file is added in '<volumes>' volumes
And I select 'Configure Agent Settings'
And I click on 'Volume Level Backup Control'
When I exclude '<volumeName>' volume
And I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
And backup should be completed successfully
And I click on 'RestoreMenu'
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'Unmount' to be visible
Then I verify retrieved 1 file/files from '<firstRetriveForVolumes>' volumes
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
Then I verify retrieved 1 file/files from '<firstRetriveForVolumes>' volumes


Examples:
|volumeName|firstRetriveForVolumes|secondRetriveForVolumes|volumes|
|E|H, I|E, H, I|E, H, I|