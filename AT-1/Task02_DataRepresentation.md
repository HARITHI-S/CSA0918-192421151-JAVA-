# Task 2 – Choose the Data Representation

| Data | Java type | Reason |
|---|---|---|
| Floor index | `int` | Whole-number index |
| Slot index | `int` | Whole-number index |
| Registration number | `String` | Contains letters and digits |
| Ticket number | `long` | Unique increasing identifier |
| Entry time | `LocalDateTime` | Date and time without manual string parsing |
| Duration | `long` minutes | Whole elapsed minutes |
| Fee | `double` | Represents decimal currency in this educational model |

A jagged array `String[][] slots` is appropriate because each floor can have a different number of slots. `slots[floor]` is an array whose length is the capacity of that floor.

For billing, avoid `minutes / 60` when every started hour is charged: integer division truncates. For example, `61 / 60` is `1`, but 61 minutes must be billed as 2 hours. Use `(minutes + 59) / 60` for non-negative integer minutes. Avoid casting after division, such as `(double)(minutes / 60)`, because precision has already been lost.

Input can be read using `Scanner`; command-line arguments are useful for automated runs.

## Alternative representations
A flat array needs a known fixed slots-per-floor value and index calculation `floor * slotsPerFloor + slot`. It becomes awkward when floor capacities differ. A jagged array directly represents different capacities. An `ArrayList<String[]>` is flexible when floors are added or removed. Slot lookup by known floor and slot index is O(1) in all three representations; scanning for the first free slot is O(total slots). Space is O(total slots).
