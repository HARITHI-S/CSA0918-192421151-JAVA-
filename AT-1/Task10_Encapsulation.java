class ParkingSlot {
    private final int floor;
    private final int slotNumber;
    private String registration;

    ParkingSlot(int floor, int slotNumber) {
        if (floor < 0 || slotNumber < 0) throw new IllegalArgumentException("Invalid slot position");
        this.floor = floor;
        this.slotNumber = slotNumber;
    }

    public int getFloor() { return floor; }
    public int getSlotNumber() { return slotNumber; }
    public String getRegistration() { return registration; }

    public void park(String regNo) {
        if (regNo == null || regNo.isBlank()) throw new IllegalArgumentException("Registration required");
        if (registration != null) throw new IllegalStateException("Slot already occupied");
        registration = regNo;
    }

    public void release() {
        if (registration == null) throw new IllegalStateException("Slot already free");
        registration = null;
    }
}

public class Task10_Encapsulation {
    public static void main(String[] args) {
        ParkingSlot slot = new ParkingSlot(0, 1);
        slot.park("TN01AB1234");
        System.out.println(slot.getRegistration());
        slot.release();
        System.out.println(slot.getRegistration());
    }
}
