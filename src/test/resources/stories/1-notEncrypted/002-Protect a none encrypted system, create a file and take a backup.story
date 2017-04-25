Meta:
@Not_Encrypted

Scenario: 002-Before performing first backup after protecting system, select "Configure System Settings", scroll down to "Volume Level Backup Control" and exclude 1 volume. Proceed to take one of backups.

Given I login to the Datto
And I click on 'Protect'
And A new text file is added in '<volumes>' volumes
When I select 'Configure Agent Settings'
And I click on 'Volume Level Backup Control'
And I exclude '<largeVolume>' volume
And I exclude '<volumeToBeExcluded>' volume
And I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|
|C|E|H, I|