Meta:
@Not_Encrypted
Scenario: 005-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the large volume and perform one backup. 

Given User is logged in to Datto App
And There is a protected system
When Navigating to 'Remove System' page
And Removing all restored points from recovery section related to selected system
And Inserting 'DeleteTextConfirm' text in the 'RemoveAgentConfirm' field to confirm
And Selecting Agent Based SYSTEM from system backup wizard
And Filling valid Address in 'Hostname'
And Keeping the default settings in 'take local backups' window
And Keeping the default settings in 'send backups to cloud' window
And Keeping the default settings in 'keep your backups' window
And Filling valid email in 'receive screensot proof' window
And Filling valid emails in 'send alerts & reports' window
And Keeping default settings in 'encrypt the systme(s)' window
And Clicking on 'Continue'
And Navigating to 'Configure Agent Settings' page
And Excluding '<largeVolume>' volume
And Confirming excluding the '<largeVolume>' volume
And Navigating to 'Protect' page
And Taking one backup
Then backup should be completed successfully






When I wait 'Remove Agent' image to be visible
And I select 'Remove Agent'
And I wait 'RecoverySection' to be visible
And I click on 'RemoveRestore'
And I wait 'ForceUnmount' to be visible
And I click on 'ForceUnmount'
And I enter 'DeleteTextConfirm' inside RemoveAgentConfirm
And I click on 'RemoveAgentDelete'
And I wait 'AddBasedSystem' to be visible
And I click on 'AddBasedSystem'
And I click on 'IpAddressOrHost'
And I enter '<machineType>' inside IpAddressTextBox
And I click on 'NextButton'
And I wait 'nextIcon' to be visible
And I click on 'NextButton'
And I wait 'LocalBackups' to be visible
And I click on 'NextButton'
And I wait 'CloudBackups' to be visible
And I click on 'NextButton'
And I wait 'RetentionBackups' to be visible
And I click on 'NextButton'
And I wait 'EmailAddress' to be visible
And I enter 'ValidEmail' inside EmailAddress
And I click on 'NextButton'
And I wait 'AlerAndReports' to be visible
And I enter 'ValidEmail' inside CriticalEmail
And I click on 'NextButton'
And I wait 'EncryptSection' to be visible
And I click on 'NextButton'
And I wait 'AgentCreated' to be visible
And I click on 'Continue'
And I wait 'ProtectedSystemsHeader' to be visible
And ProtectedSystemsHeader should be displayed
And I select 'Configure Agent Settings'
And I click on 'Volume Level Backup Control'
And I exclude '<largeVolume>' volume
And I do not exclude any volume
And I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
Then backup should be completed successfully

Examples:
|largeVolume|machineType|
|C|Windows|