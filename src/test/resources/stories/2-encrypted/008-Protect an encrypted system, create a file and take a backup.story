Meta:
@Encrypted
Scenario: 008-Before performing first backup after protecting system, select "Configure System Settings", scroll down to "Volume Level Backup Control" and exclude 1 volume. Proceed to take numerous of backups.

Given User is logged in to Datto App
And There is a protected system
And A new Test.txt file is added in '<volumes>' volumes
When Navigating to 'Configure Agent Settings' page
And Excluding '<largeVolume>' volume
And Confirming excluding the '<largeVolume>' volume
And Excluding '<volumeToBeExcluded>' volume
And Confirming excluding the '<volumeToBeExcluded>' volume
And Navigating to 'PROTECT' page
And Taking one backup
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|
|C|E|H, I|