class TicketCounter {
    private static long nextTicket = 1001;

    public static long nextNumber() {
        return nextTicket++;
    }
}

class ActiveTicket {
    private final long number;

    ActiveTicket() {
        number = TicketCounter.nextNumber();
    }

    public long getNumber() {
        return number;
    }
}

public class Task05_StaticLifecycle {
    public static void main(String[] args) {
        ActiveTicket a = new ActiveTicket();
        ActiveTicket b = new ActiveTicket();
        System.out.println(a.getNumber());
        System.out.println(b.getNumber());
    }
}
