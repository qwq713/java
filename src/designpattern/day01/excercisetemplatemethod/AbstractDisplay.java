package designpattern.day01.excercisetemplatemethod;

/**
 * java 8 부터는 default 접근제어자를 이용하여
 * interface 구체적인 메서드를 구현할 수 있다.
 * */
public interface AbstractDisplay {
    /**
     * open , print, close 는 하위 클래스에 구현을 맡기는 추상 메소드
     */
    void open();

    void print();

    void close();

    default void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
