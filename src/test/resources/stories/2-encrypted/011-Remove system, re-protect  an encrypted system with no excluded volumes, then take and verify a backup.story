Meta:
@Encrypted
Scenario: 011-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the bigest one and perform one backup. 

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'Remove Agent' page
And Removing all restored points from recovery section related to selected system
And Inserting 'DeleteTextConfirm' text in the 'RemoveAgentConfirm' field to confirm
And Selecting 'AGENT BASED SYSTEM' from system backup wizard
And Filling '<MachineIP>' Address in 'Hostname'
And Keeping the default settings in 'take local backups' window
And Keeping the default settings in 'send backups to cloud' window
And Keeping the default settings in 'keep your backups' window
And Filling 'validEmail' email in 'receive screensot proof' window
And Filling 'validEmail' emails in 'send alerts & reports' window
And Choosing to encrypte the system in 'encrypt the systme(s)' window
And Accepting agent encryption agrement
And Filling '<Passphrase>' in 'Enter Passphrase' field
And Filling '<Passphrase>' in 'Repeat Passphrase' field
And Clicking 'Continue'
And Navigating to 'Configure Agent Settings' page
And Excluding '<largeVolume>' volume
And Confirming excluding the '<largeVolume>' volume
And Navigating to 'Protect' page
And Taking one backup
Then backup should be completed successfully

Examples:
|MachineIP|validEmail|ValidDeleteText|largeVolume|
|Windows|malmohtadi@aspire-infotech.net|delete my local and cloud data|C|

