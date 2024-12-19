package designpattern.day01.templatemethod;

public abstract class AbstractDisplay {
    /**
     * open , print, close 는 하위 클래스에 구현을 맡기는 추상 메소드
     */
    protected abstract void open();

    protected abstract void print();

    protected abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
