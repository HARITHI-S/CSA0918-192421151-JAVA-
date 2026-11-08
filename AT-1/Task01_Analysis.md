# Task 1 – Understand the Problem and Identify the Objects

## Inputs and outputs
Inputs: vehicle registration number, vehicle category, user category, monthly-pass validity, requested entry/exit operation, floor/slot configuration and entry/exit time.

Outputs: allocated floor and slot, unique ticket number, entry time, exit time, parking duration, fee, occupancy and error messages when an operation is invalid.

## Candidate classes and responsibilities
- `Vehicle`: common registration number and vehicle behaviour. It avoids repeating common vehicle data.
- `TwoWheeler`, `Car`, `ElectricCar`: represent vehicle categories and their different hourly rates.
- `ParkingSlot`: stores one slot's number and current vehicle/ticket. It prevents two vehicles occupying one slot.
- `ParkingFloor`: owns the slots on one floor and searches for a free suitable slot.
- `ParkingFacility`: coordinates floors, entry, exit and occupancy.
- `ParkingTicket`: records a unique ticket number, vehicle, entry time and exit details.
- `ParkingUser`: stores user type and pass validity.
- `FeeCalculator`: applies the pricing rules in one place.

## Business rules
1. A slot can contain at most one vehicle.
2. A registration number cannot have two active tickets.
3. Ticket numbers are unique and never reused during the program run.
4. An invalid floor or slot must not change the facility.
5. A vehicle can leave only if it has an active ticket.
6. A valid student/staff monthly pass makes the parking fee zero.
7. Visitors pay the applicable fee.
8. Charging fees apply only to chargeable vehicles.

## Assumptions
- Time is measured using Java `LocalDateTime`.
- A started hour is charged as a complete hour in the completed-code exercise.
- The facility may have a different slot count on each floor.
- A ticket counter starts at 1001 for each application run.
- A monthly pass is considered valid only when its validity flag is true.

## Alternative: objects versus parallel arrays
With objects, a `Vehicle` stores its registration, category and related behaviour together. With parallel arrays, the same vehicle's values must be kept at the same index in `regNo[]`, `type[]` and `entryTime[]`. Searching by registration is O(n) in either representation. Object storage uses one reference per array position plus each object's fields; parallel arrays store each attribute in a separate array. Adding a new attribute to parallel arrays requires another array and careful index synchronisation. With objects, a field can be added to the class, which is easier to maintain.
