Meta:
@Encrypted
Scenario: 009-Before performing a file restore for an encrypted protected system, delete 1 file and verify it is restored.

Given User is logged in to Datto App
And There is a protected system
And Delete '<fileName>' file from '<volumesName>' volumes
When Navigating to 'RESTORE' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a 'last' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
And Filling '<validPassphrase>' in 'Verify Passphrase' popup
Then 'Samba Share' Url should display
And '<fileName>' file is retrieved from '<volumesName>' volumes

Examples:
|system|recoveryType|volumesName|fileName|validPassphrase|
|DATTO-ALMOHTAD|File Restore|H,I|Test.txt|123|

