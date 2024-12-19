package designpattern.day01.adapterwithclass;

public class Main {
    /**
     * 어뎁터 패턴 ( Wrapper )
     * 이미 제공된 코드를 그대로 사용할 수 없을  필요한 형태로 변환 후 사용
     *
     * - 상속 ( 클래스 )
     * - 구현 ( 위임 )
     * */

    public static void main(String[] args) {
        Print print = new PrintBanner("Hello");
        print.printWeak();
        print.printStrong();
    }
}
