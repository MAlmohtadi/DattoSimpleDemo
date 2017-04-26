Meta:
@Not_Encrypted
Scenario: 005-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the large volume and perform one backup. 

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'Remove Agent' page
And Removing all restored points from recovery section related to selected system
And Inserting '<ValidDeleteText>' text in the 'RemoveAgentConfirm' field to confirm
And Selecting 'AGENT BASED SYSTEM' from system backup wizard
And Filling '<MachineIP>' Address in 'Hostname'
And Keeping the default settings in 'take local backups' window
And Keeping the default settings in 'send backups to cloud' window
And Keeping the default settings in 'keep your backups' window
And Filling '<validEmail>' email in 'receive screensot proof' window
And Filling '<validEmail>' emails in 'send alerts & reports' window
And Keeping the default settings in 'encrypt the systme(s)' window
And Clicking 'Continue'
And Navigating to 'Configure Agent Settings' page
And Excluding '<largeVolume>' volume
And Confirming excluding the '<largeVolume>' volume
And Navigating to 'Protect' page
And Taking one backup
Then backup should be completed successfully

Examples:
|MachineIP|validEmail|ValidDeleteText|largeVolume|fileName|
||Windows|malmohtadi@aspire-infotech.net|delete my local and cloud data|C|Test.txt|



