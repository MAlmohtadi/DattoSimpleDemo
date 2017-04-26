Meta:
@Not_Encrypted
Scenario: 001-Remove system from Datto appliance and re-protect the system

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'Remove System' page
And Removing all restored points from recovery section related to selected system
And Inserting 'DeleteTextConfirm' text in the 'RemoveAgentConfirm' field to confirm
And Selecting 'AGENT BASED SYSTEM' from system backup wizard
And Filling '<MachineIP>' Address in 'Hostname'
And Keeping the default settings in 'take local backups' window
And Keeping the default settings in 'send backups to cloud' window
And Keeping the default settings in 'keep your backups' window
And Filling 'validEmail' email in 'receive screensot proof' window
And Filling 'validEmail' emails in 'send alerts & reports' window
And Keeping the default settings in 'encrypt the systme(s)' window
Then system should be protected successfully

Examples:
|MachineIP|validEmail|
|Windows|malmohtadi@aspire-infotech.net|


