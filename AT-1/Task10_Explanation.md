# Task 10 – Packages and Encapsulation

Suggested package structure for a larger application:
- `parking.model`: Vehicle, ParkingSlot, ParkingTicket and user/pass classes.
- `parking.service`: allocation and fee services.
- `parking.app`: main application and user interface.

Fields should normally be `private`; constructors and public operations are exposed only when needed. `protected` supports subclass access, while package-private access is suitable for internal classes in one package. Setters and operations validate values before changing state.

Wrapper classes such as `Integer` are useful in generic collections. Do not compare wrapper objects using `==` to compare numeric values; use `equals()` or unbox safely. Public fields would allow callers to bypass validation. Validation costs O(1) per update, but centralising it in one setter avoids repeating checks at many call sites.
