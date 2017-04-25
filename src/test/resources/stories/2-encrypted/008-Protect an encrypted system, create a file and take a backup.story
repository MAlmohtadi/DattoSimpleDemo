Meta:
@Encrypted
Scenario: 008-Before performing first backup after protecting system, select "Configure System Settings", scroll down to "Volume Level Backup Control" and exclude 1 volume. Proceed to take numerous of backups.

Given I login to the Datto
And I click on 'Protect'
And A new text file is added in '<volumes>' volumes
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I exclude '<largeVolume>' volume
And I exclude '<volumeToBeExcluded>' volume
When I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|
|C|E|H, I|