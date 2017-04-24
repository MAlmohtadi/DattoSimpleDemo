Meta:
@Encrypted
Scenario: 009-Perform a file restore of last timestamp and retrieve 1 file from each backed up volume.

Given System is protected as encrypted
And Backup is available for multiple volumes
And 1 text file, is deleted from '<NameOfVolumesSeperatedByComma>' volume
When I perform file restore of last timestamp for encrypted system
Then All files should be restored for '<NameOfVolumesSeperatedByComma>' volumes

Examples:
|NameOfVolumesSeperatedByComma|
|H, I|