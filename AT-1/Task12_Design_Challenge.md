# Task 12 – Re-evaluate and Adapt the Design

## A. Impact analysis
The new requirements add e-bikes, delivery vans, a visitor one-day pass and five floors with different capacities. Vehicle hierarchy, pricing rules, pass handling and facility capacity are affected. A jagged array is suitable because each floor has a different slot count.

## B. Evaluate the original design
The abstract Vehicle design can be extended with new subclasses. However, a hard-coded rate method is not sufficient for time-dependent delivery-van pricing. Pricing behaviour should be encapsulated in vehicle/pricing strategies. Pass validation should be a separate capability.

## C. Adaptation
The extended implementation adds `EBike`, `DeliveryVan`, `Pass`, `MonthlyPass` and `OneDayPass`. E-bike parking has a flat fee. Delivery vans use double the car hourly rate from 09:00 inclusive to 17:00 exclusive. The five-floor jagged array accepts different capacities.

## D. Evidence-based defence
The new categories are added as subclasses without changing the existing TwoWheeler and Car classes. The active vehicle lookup is a HashMap. Tests should include an e-bike, a delivery van at 08:59, 09:00, 16:59 and 17:00, a valid visitor day pass, an invalid pass and a full five-floor facility.

**Assumption requiring faculty confirmation:** The assignment says visitors may buy a one-day pass but does not specify its price or whether it makes parking free. The sample extension treats a valid one-day pass as free parking and does not invent a purchase price. Confirm the intended rule before final submission.
