Meta:
@Not_Encrypted
Scenario: 004-Perform a file restore of any desired timestamp and retrieve 10 files from each backed up volume. 

Given System is protected as not encrypted
And There are 10 text files in '<NameOfVolumesSeperatedByComma>' volumes
And A backup is captured for all volumes
When I delete the 10 files in each backed up volume
And I perform file restore of specific timestamp
Then I verify retrieved 10 files from '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|
|H,I|