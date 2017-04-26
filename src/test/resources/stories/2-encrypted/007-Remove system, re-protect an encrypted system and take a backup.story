Meta:
@Encrypted
Scenario: 007-Remove any previous system then Add a new system as encrypted.

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'Remove Agent' page
And Removing all restored points from recovery section related to selected system
And Inserting '<ValidDeleteText>' text in the 'Confirm' field
And Selecting 'AGENT BASED SYSTEM' from system backup wizard
And Filling '<MachineIP>' Address in 'Hostname'
And Keeping the default settings in 'take local backups' window
And Keeping the default settings in 'send backups to cloud' window
And Keeping the default settings in 'keep your backups' window
And Filling '<validEmail>' email in 'receive screenshot proof' window
And Filling '<validEmail>' emails in 'send alerts & reports' window
And Choosing to encrypte the system in 'encrypt the systme(s)' window
And Accepting agent encryption agrement
And Filling '<validPassphrase>' in 'Enter Passphrase' field
And Filling '<validPassphrase>' in 'Repeat Passphrase' field
Then system should be protected successfully

Examples:
|MachineIP|validEmail|ValidDeleteText|validPassphrase|
|Windows|malmohtadi@aspire-infotech.net|delete my local and cloud data|123|
