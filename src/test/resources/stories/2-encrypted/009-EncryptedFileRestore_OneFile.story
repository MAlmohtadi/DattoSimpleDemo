Meta:
@Encrypted
Scenario: 009-Before performing a file restore for an encrypted protected system, delete 1 file and verify it is restored.

Given user is logged in to Datto App
And there is a protected system
And delete '<fileName>' file from '<volumesName>' volumes
When navigating to 'RESTORE' page
And choosing a '<system>' system to be restored
And choosing a '<recoveryType>' recovery type
And choosing a 'last' recovery point
And clicking 'START FILE RESTORE'
And clicking 'MOUNT' to shere file recovery
And filling '<validPassphrase>' in 'Verify Passphrase' popup
Then 'Samba Share' Url should display
And '<fileName>' file is retrieved from '<volumesName>' volumes

Examples:
|system|recoveryType|volumesName|fileName|validPassphrase|
|DATTO-ALMOHTAD|File Restore|H,I|Test.txt|123|

