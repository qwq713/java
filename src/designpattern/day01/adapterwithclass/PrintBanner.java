package designpattern.day01.adapterwithclass;

public class PrintBanner extends Banner implements Print{
    // string 이 필요함.
    public PrintBanner(String string) {
        super(string);
    }

    /**
     * 어뎁터 클래스
     * -> 이미 주어진 것 ( Banner ) 을
     * -> 새로운 규격 ( Print ) 에 맞게 동작하도록 함.
     *
     * Banner 를 상속한다. ( 코드를 재사용한다 )
     * Print를 implements 한다. ( 새로운 규격에 맞춘다. )
     * */

    @Override
    public void printWeak() {
        this.showWithParen();
    }

    @Override
    public void printStrong() {
        this.showWithAster();
    }
}
