Meta:
@Encrypted
Scenario: 012-Before performing backup after protecting system, exclude 1 volume, perform a file restore of any desired timestamp.  Proceed include all volumes and retrieve 1 file from a backed up volume. 

Given System is protected as encrypted
And A new text file is added in 'volumes' volumes
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
When I exclude 'volumeName' volume
And I take a backup
And backup should be completed successfully
And I perform a file restore for 1 file from each backed up volume of specific timestamp.
Then I verify retrieved 1 file, from 'firstRetriveForVolumes' volumes
When I click on 'Protect'
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I include the excluded 'volumeName' volume
And I take a backup
And backup should be completed successfully
And I perform a file restore for 1 file from each backed up volume of specific timestamp.
Then I verify retrieved 1 file, from 'secondRetriveForVolumes' volumes

Examples:
|volumeName|firstRetriveForVolumes|secondRetriveForVolumes|volumes|
|E|H, I|E, H, I|E, H, I|