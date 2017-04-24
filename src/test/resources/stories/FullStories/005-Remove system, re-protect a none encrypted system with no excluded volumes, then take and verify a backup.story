Meta:
@Not_Encrypted
Scenario: 005-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the large volume and perform one backup. 

Given System is protected as not encrypted
When I remove system from Datto appliance
And I re-protect the system as not encrypted for <machineType>
And The system is protected
And I select 'Configure Agent Settings'
And I click on 'VolumeLevelBackupControl'
And I exclude '<largeVolume>' volume
And I do not exclude any volume
And I take a backup
Then System should be backed up

Examples:
|largeVolume|machineType|
|C|Windows|