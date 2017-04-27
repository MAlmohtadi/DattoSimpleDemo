Meta:
@Encrypted
Scenario: 007-Remove system from Datto appliance and re-protect the system as encrypted

Given user is logged in to Datto App
And there is a protected system
When navigating to 'Remove Agent' page
And removing all restored points from recovery section related to selected system
And inserting '<validDeleteText>' text in the 'Confirm' field
And selecting 'AGENT BASED SYSTEM' from system backup wizard
And filling '<machineIP>' Address in 'Hostname'
And keeping the default settings in 'take local backups' window
And keeping the default settings in 'send backups to cloud' window
And keeping the default settings in 'keep your backups' window
And filling '<validEmail>' email in 'receive screenshot proof' window
And filling '<validEmail>' emails in 'send alerts & reports' window
And choosing to encrypte the system in 'encrypt the systme(s)' window
And accepting agent encryption agrement
And filling '<validPassphrase>' in 'Enter Passphrase' field
And filling '<validPassphrase>' in 'Repeat Passphrase' field
Then system should be protected successfully

Examples:
|machineIP|validEmail|validDeleteText|validPassphrase|
|Windows|malmohtadi@aspire-infotech.net|delete my local and cloud data|123|
