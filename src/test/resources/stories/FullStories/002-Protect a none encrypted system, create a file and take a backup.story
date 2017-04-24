Meta:
@Not_Encrypted

Scenario: 002-Before performing first backup after protecting system, select "Configure System Settings", scroll down to "Volume Level Backup Control" and exclude 1 volume. Proceed to take one of backups.

Given System is protected as not encrypted
And A new text file is added in '<volumes>' volumes
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I exclude '<largeVolume>' volume
And I exclude '<volumeToBeExcluded>' volume
When I take a backup
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|
|C|E|H,I|