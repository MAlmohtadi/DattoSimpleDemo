Meta:
@Encrypted
Scenario: 008-Before performing first backup after protecting system, select "Configure System Settings", scroll down to "Volume Level Backup Control" and exclude 1 volume. Proceed to take numerous of backups.

Given System is protected as encrypted
And A new text file is added in 'volumes' volumes
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I exclude 'volumeToBeExcluded1' volume
And I exclude 'volumeToBeExcluded2' volume
When I take a backup
Then backup should be completed successfully

Examples:
|volumeToBeExcluded1|volumeToBeExcluded2|volumes|
|C|E|H, I|