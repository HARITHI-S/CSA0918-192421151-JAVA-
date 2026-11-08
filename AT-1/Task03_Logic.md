# Task 3 – Control Logic

## Allocation pseudocode
1. START.
2. FOR each floor from first to last:
   - FOR each slot on that floor:
     - IF the slot is empty, store the vehicle number and RETURN the floor and slot.
3. RETURN null when no free slot exists.
4. STOP.

## Release pseudocode
1. START.
2. IF floor index is outside the valid range, RETURN false.
3. IF slot index is outside that floor's range, RETURN false.
4. IF the slot is already empty, RETURN false.
5. Set the slot to empty and RETURN true.
6. STOP.

## Fee pseudocode
1. START.
2. IF minutes is zero or negative, use zero billable hours.
3. Otherwise calculate hours = (minutes + 59) / 60.
4. Calculate fee = hours × hourly rate.
5. Apply any valid pass or daily maximum rule.
6. RETURN fee.

## Complexity
Let N be the total number of slots. A scan-based allocate is O(N) worst case and O(1) extra space. Release by direct floor/slot index is O(1). A stack of free slot coordinates can make allocation and release O(1) average time, but needs O(N) additional storage and careful synchronisation with occupancy.
