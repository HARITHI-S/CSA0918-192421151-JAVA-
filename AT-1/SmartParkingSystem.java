import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/** Complete educational parking-system implementation for Task 11. */
public class SmartParkingSystem {
    enum UserType { STUDENT, STAFF, VISITOR }
    enum VehicleType { TWO_WHEELER, CAR, ELECTRIC_CAR }

    static abstract class Vehicle {
        private final String regNo;
        Vehicle(String regNo) {
            if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Invalid registration");
            this.regNo = regNo.trim().toUpperCase();
        }
        String getRegNo() { return regNo; }
        abstract double hourlyRate();
    }
    static class TwoWheeler extends Vehicle {
        TwoWheeler(String r) { super(r); }
        double hourlyRate() { return 10; }
    }
    static class Car extends Vehicle {
        Car(String r) { super(r); }
        double hourlyRate() { return 30; }
    }
    static class ElectricCar extends Car {
        ElectricCar(String r) { super(r); }
    }

    static class Ticket {
        private static long nextNo = 1001;
        final long number = nextNo++;
        final Vehicle vehicle;
        final UserType userType;
        final boolean validMonthlyPass;
        final LocalDateTime entry = LocalDateTime.now();
        int floor, slot;
        Ticket(Vehicle v, UserType u, boolean pass, int f, int s) {
            vehicle = v; userType = u; validMonthlyPass = pass; floor = f; slot = s;
        }
    }

    private final String[][] slots;
    private final Map<String, Ticket> active = new LinkedHashMap<>();

    SmartParkingSystem(int[] capacity) {
        slots = new String[capacity.length][];
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] < 0) throw new IllegalArgumentException("Negative floor capacity");
            slots[i] = new String[capacity[i]];
        }
    }

    Ticket enter(Vehicle v, UserType user, boolean validPass) {
        if (active.containsKey(v.getRegNo())) throw new IllegalStateException("Duplicate active registration");
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = v.getRegNo();
                    Ticket t = new Ticket(v, user, validPass, f, s);
                    active.put(v.getRegNo(), t);
                    return t;
                }
            }
        }
        throw new IllegalStateException("Parking facility is full");
    }

    double exit(String regNo, long minutes) {
        if (minutes < 0) throw new IllegalArgumentException("Negative duration");
        Ticket t = active.remove(regNo.toUpperCase());
        if (t == null) throw new NoSuchElementException("No active ticket");
        slots[t.floor][t.slot] = null;
        if ((t.userType == UserType.STUDENT || t.userType == UserType.STAFF) && t.validMonthlyPass) return 0;
        long hours = (minutes + 59) / 60;
        double rate = t.vehicle.hourlyRate();
        return hours * rate;
    }

    int occupancy() { return active.size(); }

    public static void main(String[] args) {
        SmartParkingSystem p = new SmartParkingSystem(new int[]{2, 1});
        Ticket a = p.enter(new TwoWheeler("TN01A1"), UserType.VISITOR, false);
        Ticket b = p.enter(new Car("TN02B2"), UserType.STUDENT, true);
        System.out.println("Ticket " + a.number + " allocated " + a.floor + ":" + a.slot);
        System.out.println("Ticket " + b.number + " allocated " + b.floor + ":" + b.slot);
        System.out.println("Visitor fee for 61 minutes = Rs " + p.exit("TN01A1", 61));
        System.out.println("Student pass fee for 120 minutes = Rs " + p.exit("TN02B2", 120));
        System.out.println("Occupancy = " + p.occupancy());
    }
}
