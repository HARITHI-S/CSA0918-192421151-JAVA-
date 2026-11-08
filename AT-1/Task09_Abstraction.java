interface Chargeable {
    double chargingFee(int kWh);

    default String chargingMessage() {
        return "Charging service available";
    }

    static boolean validEnergy(int kWh) {
        return kWh >= 0;
    }
}

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo;
    }

    public String getRegNo() { return regNo; }
    abstract double ratePerHour();
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String regNo) { super(regNo); }
    @Override double ratePerHour() { return 30; }
    @Override public double chargingFee(int kWh) {
        if (!Chargeable.validEnergy(kWh)) throw new IllegalArgumentException("Invalid kWh");
        return kWh * 12.0;
    }
}

public class Task09_Abstraction {
    public static void main(String[] args) {
        ElectricCar e = new ElectricCar("TN01EV1234");
        System.out.println(e.getRegNo());
        System.out.println(e.chargingMessage());
        System.out.println(e.chargingFee(5));
    }
}
