Meta:
@Not_Encrypted
Scenario: 003-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.

Given User is logged in to Datto App
And There is a protected system
And Delete '<fileName>' file from '<volumesName>' volumes
When Navigating to 'RESTORE' page
And Choosing a '<system>' system to be restored
And Choosing a '<recoveryType>' recovery type
And Choosing a 'last' recovery point
And Clicking 'START FILE RESTORE'
And Clicking 'MOUNT' to shere file recovery
Then 'Samba Share' Url should display
And '<fileName>' file is retrieved from '<volumesName>' volumes

Examples:
|system|recoveryType|volumesName|fileName|
|DATTO-ALMOHTAD|File Restore|H,I|Test.txt|
