Meta:
@Encrypted
Scenario: 011-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the bigest one and perform one backup. 

Given I am logged in to Datto App
And I click on 'Protect'
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
And I click on 'EncryptYes'
And I click on 'IAgreeButton'
And I wait 'EnterPassphrase' to be visible
And I enter 'ValidPassphrase' inside EnterPassphrase
And I enter 'ValidPassphrase' inside RepeatPassphrase
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