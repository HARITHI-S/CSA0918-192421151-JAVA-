import java.util.Objects;

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        this.regNo = regNo;
    }

    abstract double ratePerHour();

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + regNo + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vehicle other && regNo.equals(other.regNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNo);
    }
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }
    @Override double ratePerHour() { return 30; }
}

public class Task07_Overriding {
    public static void main(String[] args) {
        Vehicle a = new Car("TN01AB1234");
        Vehicle b = new Car("TN01AB1234");
        System.out.println(a);
        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
    }
}
