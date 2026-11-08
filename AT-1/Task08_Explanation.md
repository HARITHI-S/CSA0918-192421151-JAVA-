# Task 8 – Polymorphism

Compile-time polymorphism occurs when overloaded methods have the same name but different parameter lists. Runtime polymorphism occurs when a `Vehicle` reference points to a subclass object and the overridden method is selected at runtime.

Trace: declared reference type = `Vehicle`; actual object type = `ElectricCar`; call = `calculateFee(130)`; `Vehicle.calculateFee` calls `ratePerHour`; dynamic dispatch selects `Car.ratePerHour` (inherited by ElectricCar), which returns 30. Three started hours cost Rs 90; 10 kWh charging costs Rs 120; total Rs 210, matching the expected output.

The provided `equals` implementation prints true for a Car and ElectricCar with the same registration because equality is based only on registration number. This is suitable only if registration number defines vehicle identity regardless of subtype.
