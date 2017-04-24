Meta:
@Not_Encrypted
Scenario: 004-Perform a file restore of any desired timestamp and retrieve 10 files from each backed up volume. 

Given System is protected as not encrypted
And There are 10 text files in '<NameOfVolumesSeperatedByComma>' volumes
When A backup is captured for all volumes
And I delete the 10 files in <NameOfVolumesSeperatedByComma> volume
And I perform file restore of last timestamp for not encrypted system
Then I verify retrieved 10 files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|number|
|H,I|10|