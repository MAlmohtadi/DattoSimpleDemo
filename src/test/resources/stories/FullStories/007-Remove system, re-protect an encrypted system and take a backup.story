Meta:
@Encrypted
Scenario: 007-Remove any previous system then Add a new system as encrypted.

Given System is protected as not encrypted
When I remove a not encrypted system from Datto appliance
And I re-protect the system as not encrypted for machineType
Then The system is protected

Examples:
|biggestVolume|machineType|
|C|Windows|