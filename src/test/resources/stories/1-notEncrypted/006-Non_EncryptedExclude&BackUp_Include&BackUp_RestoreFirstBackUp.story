Meta:
@Not_Encrypted
Scenario: 006-Before performing backup and restore for non-encrypted protected system, exclude a volume, take backup, include another volume and take another backup, then restore first backup.

Given User is logged in to Datto App
And There is a protected system
And A new <fileName1> file is added in '<volumes1>' volumes
When Navigating to 'Configure Agent Settings' page
And Excluding '<volumeToBeExcluded>' volume
And Confirming excluding the '<volumeToBeExcluded>' volume
And Navigating to 'Protect' page
And A backup is taken
And A new <fileName2> file is added in '<volumes2>' volumes
And Navigating to 'Configure Agent Settings' page
And Including '<volumeToBeExcluded>' volume
And Navigating to 'Protect' page
And A backup is taken
And Deleting '<fileName2>' file from '<volumes2>' volumes
And Navigating to 'Restore' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a 'last' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And '<fileName1>' file is not retrieved from '<volumes>' volumes

Examples:
|volumes1|volumes2|volumeToBeExcluded|fileName1|fileName2|system|recoveryType|
|H,I|E,H,I|E|Text1.txt|Text2.txt|DATTO-ALMOHTAD|File Restore|