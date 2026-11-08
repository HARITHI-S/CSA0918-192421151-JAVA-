# Task 9 – Introduce Abstraction

`Vehicle` is an abstract class because all vehicles share state (`regNo`) and common constructor validation, but each concrete category supplies its own rate. `Chargeable` is an interface because charging is a capability that only some vehicle types have. A class may implement multiple interfaces.

If Vehicle became an interface, it could not hold per-object instance fields or use constructors to initialise registration numbers. If Chargeable became an abstract class, a class already extending Vehicle could not also extend Chargeable because Java supports only one direct superclass. Interface and abstract-class method calls both have normal JVM dispatch; there is no meaningful Big-O difference for these constant-time calls. Object state space depends on fields, not whether the contract is declared as an interface.
