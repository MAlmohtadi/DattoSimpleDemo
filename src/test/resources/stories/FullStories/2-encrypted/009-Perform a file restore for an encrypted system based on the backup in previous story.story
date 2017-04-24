Meta:
@Encrypted
Scenario: 009-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.

Given I login to the Datto
And I click on 'Protect'
And Backup is available for multiple volumes
And <number> text file/files deleted from '<NameOfVolumesSeperatedByComma>' volumes
When I click on 'RestoreMenu'
And I click on 'FileRestoreRadioButton'
And I click on 'StartFileRestore'
And I click on 'Mount'
And I wait 'PassphraseTextBox' to be visible
And I enter 'ValidPassphrase' inside PassphraseTextBox
And I click on 'VerifyPhraseButton'
And I wait 'Unmount' to be visible
Then I verify retrieved <number> file/files from '<names>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|
|H, I|1|