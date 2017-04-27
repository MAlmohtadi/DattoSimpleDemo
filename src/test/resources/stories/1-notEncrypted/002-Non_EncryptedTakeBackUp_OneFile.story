Meta:
@Not_Encrypted

Scenario: 002- Before taking backup while non-encrypted system is protected, Add 1 File, exclude volumes

Given user is logged in to Datto App
And there is a protected system
And a new <fileName> file is added in '<volumes>' volumes
When navigating to 'Configure Agent Settings' page
And excluding '<largeVolume>' volume
And confirming excluding the '<largeVolume>' volume
And excluding '<volumeToBeExcluded>' volume
And confirming excluding the '<volumeToBeExcluded>' volume
And navigating to 'PROTECT' page
And taking one backup
Then backup should be completed successfully

Examples:
|largeVolume|volumeToBeExcluded|volumes|fileName|
|C|E|H, I|Test.txt|