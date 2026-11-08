import java.util.*;

/** Task 12 extension: e-bikes, delivery vans and visitor day passes. */
public class SmartParkingExtended {
    enum UserType { STUDENT, STAFF, VISITOR }

    interface Pass {
        boolean isValid();
    }
    static class MonthlyPass implements Pass {
        private final boolean valid;
        MonthlyPass(boolean valid) { this.valid = valid; }
        public boolean isValid() { return valid; }
    }
    static class OneDayPass implements Pass {
        private final boolean valid;
        OneDayPass(boolean valid) { this.valid = valid; }
        public boolean isValid() { return valid; }
    }

    abstract static class Vehicle {
        private final String regNo;
        Vehicle(String regNo) {
            if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
            this.regNo = regNo.toUpperCase();
        }
        String getRegNo() { return regNo; }
        abstract double fee(int minutes, int hourOfDay);
    }
    static class TwoWheeler extends Vehicle {
        TwoWheeler(String r) { super(r); }
        double fee(int m, int h) { return ((m + 59) / 60) * 10.0; }
    }
    static class Car extends Vehicle {
        Car(String r) { super(r); }
        double fee(int m, int h) { return ((m + 59) / 60) * 30.0; }
    }
    static class ElectricCar extends Car {
        ElectricCar(String r) { super(r); }
    }
    static class EBike extends Vehicle {
        EBike(String r) { super(r); }
        double fee(int m, int h) { return 15.0; } // flat parking fee
    }
    static class DeliveryVan extends Vehicle {
        DeliveryVan(String r) { super(r); }
        double fee(int m, int h) {
            int hours = (m + 59) / 60;
            double rate = (h >= 9 && h < 17) ? 60.0 : 30.0;
            return hours * rate;
        }
    }

    private final String[][] slots;
    private final Map<String, Vehicle> active = new HashMap<>();

    SmartParkingExtended(int[] capacities) {
        slots = new String[capacities.length][];
        for (int i = 0; i < capacities.length; i++) {
            if (capacities[i] < 0) throw new IllegalArgumentException("Invalid capacity");
            slots[i] = new String[capacities[i]];
        }
    }

    void enter(Vehicle v) {
        if (active.containsKey(v.getRegNo())) throw new IllegalStateException("Duplicate registration");
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = v.getRegNo();
                    active.put(v.getRegNo(), v);
                    System.out.println(v.getClass().getSimpleName() + " allocated " + f + ":" + s);
                    return;
                }
            }
        }
        throw new IllegalStateException("Facility full");
    }

    double exit(String regNo, int minutes, int exitHour, UserType user, Pass pass) {
        Vehicle v = active.remove(regNo.toUpperCase());
        if (v == null) throw new NoSuchElementException("Vehicle not found");
        for (String[] floor : slots) {
            for (int s = 0; s < floor.length; s++) {
                if (regNo.equalsIgnoreCase(floor[s])) { floor[s] = null; }
            }
        }
        if (pass != null && pass.isValid()
                && (user == UserType.STUDENT || user == UserType.STAFF || user == UserType.VISITOR)) {
            return 0.0;
        }
        return v.fee(minutes, exitHour);
    }

    public static void main(String[] args) {
        SmartParkingExtended p = new SmartParkingExtended(new int[]{2, 1, 2, 1, 3});
        p.enter(new EBike("TN10EB1001"));
        p.enter(new DeliveryVan("TN10DV2002"));
        System.out.println("E-bike flat fee = Rs " +
                p.exit("TN10EB1001", 90, 10, UserType.VISITOR, null));
        System.out.println("Delivery van daytime fee = Rs " +
                p.exit("TN10DV2002", 60, 10, UserType.VISITOR, null));
        p.enter(new Car("TN10CA3003"));
        System.out.println("Visitor one-day pass fee = Rs " +
                p.exit("TN10CA3003", 120, 18, UserType.VISITOR, new OneDayPass(true)));
    }
}
