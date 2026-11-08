class ParkingTicket {
    private final long ticketNo;
    private final String regNo;

    ParkingTicket() {
        this(1001L, "UNKNOWN");
    }

    ParkingTicket(long ticketNo, String regNo) {
        if (ticketNo <= 0 || regNo == null || regNo.isBlank()) {
            throw new IllegalArgumentException("Invalid ticket data");
        }
        this.ticketNo = ticketNo;
        this.regNo = regNo;
    }

    ParkingTicket(ParkingTicket other) {
        this(other.ticketNo, other.regNo);
    }

    public String toString() {
        return "Ticket " + ticketNo + " for " + regNo;
    }
}

public class Task04_Constructors {
    public static void main(String[] args) {
        ParkingTicket t1 = new ParkingTicket();
        ParkingTicket t2 = new ParkingTicket(1002L, "TN01AB1234");
        ParkingTicket t3 = new ParkingTicket(t2);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
