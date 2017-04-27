Meta:
@Encrypted
Scenario: 010-Create 10 files in encrypted protected system, take backup, delete files and verify the files after restore. 

Given user is logged in to Datto App
And <number> new '<fileName>' files are added in '<volumesName>' volumes
And a backup is taken
When deleting <number> '<fileName>' files from '<volumesName>' volumes
And navigating to 'Restore' page
And choosing a '<system>' system to be restored
And choosing a '<recoveryType>' recovery type
And choosing a 'last' recovery point
And clicking 'START FILE RESTORE'
And clicking 'MOUNT' to shere file recovery
And filling '<validPassphrase>' in 'Verify Passphrase' popup
Then 'Samba Share' Url should display
And <number> '<fileName>' files are retrieved from '<volumesName>' volumes

Examples:
|volumesName|number|fileName|system|recoveryType|validPassphrase|
|H,I|10|Test.txt|DATTO-ALMOHTAD|File Restore|123|