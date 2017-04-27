Meta:
@Encrypted
Scenario: 011-Before taking backUp for an encrypted protected system, remove system, re-protect system again.

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
And clicking 'Continue'
And navigating to 'Configure Agent Settings' page
And excluding '<largeVolume>' volume
And confirming excluding the '<largeVolume>' volume
And navigating to 'Protect' page
And taking one backup
Then backup should be completed successfully

Examples:
|machineIP|validEmail|validDeleteText|largeVolume|fileName|validPassphrase|
|Windows|malmohtadi@aspire-infotech.net|delete my local and cloud data|C|Test.txt|123|