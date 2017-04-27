Meta:
@Encrypted
Scenario: 008-Before taking backup while encrypted system is protected, Add 1 File, exclude volumes.

Given User is logged in to Datto App
And There is a protected system
And A new <fileName> file is added in '<volumes>' volumes
When Navigating to 'Configure Agent Settings' page
And Excluding '<largeVolume>' volume
And Confirming excluding the '<largeVolume>' volume
And Excluding '<volumeToBeExcluded>' volume
And Confirming excluding the '<volumeToBeExcluded>' volume
And Navigating to 'PROTECT' page
And Taking one backup
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|fileName|
|C|E|H, I|Test.txt|