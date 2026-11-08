# Task 6 – Inheritance Hierarchy

`Vehicle` is the abstract superclass. `TwoWheeler` and `Car` are subclasses (hierarchical inheritance). `ElectricCar` extends `Car` (multilevel inheritance) and implements `Chargeable`. Common registration data and the abstract rate operation are placed in `Vehicle`; subclasses supply their rate.

Constructor trace for `new ElectricCar(...)`: Vehicle constructor runs first, then Car constructor, then ElectricCar constructor. `super(...)` invokes the immediate parent constructor.

Composition alternative: a `Vehicle` could contain a `VehicleType` strategy object that supplies the rate. Adding a type then means adding a strategy rather than a subclass. Fee calculation remains O(1); object space includes a reference to the strategy and possibly a shared strategy object.
