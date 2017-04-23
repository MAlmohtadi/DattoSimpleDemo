Meta:
@Not_Encrypted
Scenario: 001-Remove system from Datto appliance and re-protect the system

Given System is protected as not encrypted
When I remove a not encrypted system from Datto appliance
And I re-protect the system as not encrypted for machineType
Then The system is protected

Examples:
|machineType|
|Windows|