# Task 11 – Implementation, Testing and Defence

## Test cases to execute
| ID | Test | Expected result |
|---|---|---|
| TC01 | Visitor two-wheeler parks and exits after 61 minutes | Rs 20 |
| TC02 | Student with valid monthly pass exits | Rs 0 |
| TC03 | Two vehicles enter a 2-slot floor | Both receive different slots |
| TC04 | Third vehicle enters a full 2-slot facility | Full-facility error |
| TC05 | Same registration enters twice | Duplicate-registration error |
| TC06 | Exit unknown registration | No-active-ticket error |
| TC07 | Negative duration | Validation error |
| TC08 | Exit valid tickets | Occupancy decreases |

Run `SmartParkingSystem.java` and compare the printed values. For a hand calculation: a visitor two-wheeler staying 61 minutes is billed for 2 started hours × Rs 10 = Rs 20. A valid student monthly pass is Rs 0.

## Design defence
The implementation uses encapsulated fields, an abstract Vehicle class, subclasses for rates, a jagged array for floor capacities and a HashMap keyed by registration number for active tickets. Entry and exit lookups in the HashMap are O(1) average; slot scanning is O(N) worst case for N slots. Active ticket storage is O(n). A limitation is that this educational version uses fixed rates and an in-memory ticket store; it does not persist records after shutdown or handle concurrent gate operations.
