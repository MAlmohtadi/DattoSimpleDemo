Meta:
@Not_Encrypted
Scenario: 006-Before performing backup after protecting system, exclude 1 volume, perform a file restore of any desired timestamp.  Proceed include all volumes and retrieve 1 file from a backed up volume. 

Given System is protected as not encrypted
And A new text file is added in '<volumes>' volumes
And I select 'Configure Agent Settings'
And I click on 'Volume Level Backup Control'
When I exclude '<volumeName>' volume
And I take a backup
And backup should be completed successfully
And I perform file restore of last timestamp for not encrypted system
Then I verify retrieved 1 file, from '<firstRetriveForVolumes>' volumes
When I click on 'Protect'
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I include the excluded '<volumeName>' volume
And I take a backup
And backup should be completed successfully
And I perform file restore of last timestamp for not encrypted system
Then I verify retrieved 1 file, from '<secondRetriveForVolumes>' volumes


Examples:
|volumeName|firstRetriveForVolumes|secondRetriveForVolumes|volumes|
|E|H, I|E, H, I|E, H, I|