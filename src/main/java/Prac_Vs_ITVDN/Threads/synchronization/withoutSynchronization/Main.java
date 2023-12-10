package Prac_Vs_ITVDN.Threads.synchronization.withoutSynchronization;

public class Main {
    public static void main(String[] args) {
        Ticket[] t = {
                new Ticket(10),
                new Ticket(20),
                new Ticket(30),
                new Ticket(40)
        };

        Cashier c1 = new Cashier(1, t);
        Cashier c2 = new Cashier(2, t);
        Cashier c3 = new Cashier(3, t);
        Cashier c4 = new Cashier(4, t);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}