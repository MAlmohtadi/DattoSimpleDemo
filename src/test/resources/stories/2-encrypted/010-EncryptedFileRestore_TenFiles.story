Meta:
@Encrypted
Scenario: 010-Create 10 files in encrypted protected system, take backup, delete files and verify the files after restore. 

Given User is logged in to Datto App
And <number> new '<fileName>' files are added in '<volumesName>' volumes
And A backup is taken
When Deleting <number> '<fileName>' files from '<volumesName>' volumes
And Navigating to 'Restore' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a 'last' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
And Filling '<validPassphrase>' in 'Verify Passphrase' popup
Then 'Samba Share' Url should display
And <number> '<fileName>' files are retrieved from '<volumesName>' volumes

Examples:
|volumesName|number|fileName|system|recoveryType|validPassphrase|
|H,I|10|Test.txt|DATTO-ALMOHTAD|File Restore|123|