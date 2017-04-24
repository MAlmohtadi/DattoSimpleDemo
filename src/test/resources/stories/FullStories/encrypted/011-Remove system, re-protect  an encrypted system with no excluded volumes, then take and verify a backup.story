Meta:
@Encrypted
Scenario: 011-Remove system from Datto appliance and re-protect the system once again. Do not exclude any volume except the bigest one and perform one backup. 

Given System is protected as encrypted
When I remove system from Datto appliance
And I re-protect the system as encrypted for <machineType>
And The system is protected
And I select 'Configure Agent Settings'
And I click on 'Volume Level Backup Control'
And I exclude '<largeVolume>' volume
And I do not exclude any volume
And I take a backup
Then System should be backed up

Examples:
|biggestVolume|machineType|
|C|Windows|