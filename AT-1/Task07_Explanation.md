# Task 7 – Override and Specialise Behaviour

Subclasses override `ratePerHour()` to provide category-specific rates. `@Override` lets the compiler detect a mismatched method signature. The overriding method cannot reduce the visibility of the parent method and must have a compatible return type. `final` is suitable for immutable registration numbers and constants; it should not be applied to a method that subclasses must override.

`equals()` compares registration numbers and `hashCode()` uses the same identity field. This means two different vehicle objects with the same registration are considered equal. That rule is appropriate for identifying a vehicle, but a live system should also reject duplicate active registrations.

A switch-based alternative puts all rates in one method. It can be O(1) for a fixed number of types, but adding a type requires changing the switch and risks violating the open/closed principle.
