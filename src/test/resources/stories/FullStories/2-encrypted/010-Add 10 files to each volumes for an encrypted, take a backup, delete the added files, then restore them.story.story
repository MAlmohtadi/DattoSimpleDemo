Meta:
@Encrypted
Scenario: 010-Perform a file restore of any desired timestamp and retrieve 10 files from each backed up volume. 

Given I login to the Datto
And I click on 'Protect'
And There are <number> text files in '<NameOfVolumesSeperatedByComma>' volumes
When I select 'protect'
And I wait 'Start Backup' image to be visible
And I select 'Start Backup'
And I wait 'Cancel' image to be visible
And backup should be completed successfully
And I delete <number> file/files in <NameOfVolumesSeperatedByComma> volumes
And I click on 'RestoreMenu'
And I wait 'RemoveRestore' to be visible
And I click on 'RemoveRestore'
And I wait 'ManageRestore' to be invisible
And I click on 'ChooseSystemRadioButton'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'PassphraseTextBox' to be visible
And I enter 'ValidPassphrase' inside PassphraseTextBox
And I click on 'VerifyPhraseButton'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|
|H, I|1|