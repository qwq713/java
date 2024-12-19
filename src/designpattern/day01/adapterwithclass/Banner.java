package designpattern.day01.adapterwithclass;

public class Banner {
    /**
     * 이미 주어진 클래스
     * */
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
