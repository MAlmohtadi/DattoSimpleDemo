Meta:
@Not_Encrypted
Scenario: 006-Before performing backup and restore for non-encrypted protected system, exclude a volume, take backup, include another volume and take another backup, then restore first backup.

Given user is logged in to Datto App
And there is a protected system
And a new <fileName1> file is added in '<volumes1>' volumes
When navigating to 'Configure Agent Settings' page
And excluding '<volumeToBeExcluded>' volume
And confirming excluding the '<volumeToBeExcluded>' volume
And navigating to 'Protect' page
And a backup is taken
And a new <fileName2> file is added in '<volumes2>' volumes
And navigating to 'Configure Agent Settings' page
And including '<volumeToBeExcluded>' volume
And navigating to 'Protect' page
And a backup is taken
And deleting '<fileName2>' file from '<volumes2>' volumes
And navigating to 'Restore' page
And choosing a '<system>' system to be restored
And choosing a '<recoveryType>' recovery type
And choosing a 'last' recovery point
And clicking 'START FILE RESTORE'
And clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And '<fileName1>' file is not retrieved from '<volumes>' volumes

Examples:
|volumes1|volumes2|volumeToBeExcluded|fileName1|fileName2|system|recoveryType|
|H,I|E,H,I|E|Text1.txt|Text2.txt|DATTO-ALMOHTAD|File Restore|