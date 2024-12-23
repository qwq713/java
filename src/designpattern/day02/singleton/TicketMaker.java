package designpattern.day02.singleton;

public class TicketMaker {
    private static TicketMaker singleton = new TicketMaker();
    private int ticket = 1000;

    private TicketMaker() {
        System.out.println("인스턴스를 생성했습니다.");
    }

    public static TicketMaker getInstance() {
        return singleton;
    }

    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

}
