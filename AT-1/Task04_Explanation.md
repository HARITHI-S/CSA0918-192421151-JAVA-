# Task 4 – Classes, Objects and Constructors

A parameterised constructor creates a ticket with validated values. The no-argument constructor delegates to it using `this(...)`, so validation and field assignment are not duplicated. The copy constructor creates another ticket with the same values; in a real parking system, a copied ticket should normally receive a new unique ticket number rather than duplicate an active ticket.

A local reference variable is stored in a stack frame; the object it refers to is allocated on the heap. The reference can be passed to methods. An object becomes eligible for garbage collection when no reachable reference points to it.

Alternative: default construction followed by setters permits a temporarily invalid object. Static factory methods can validate and return a fully initialised object. For n objects, both approaches require O(n) total object space and O(n) total construction work; constructor/factory validation makes invalid intermediate states less likely.
