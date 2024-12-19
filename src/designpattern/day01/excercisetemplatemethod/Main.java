package designpattern.day01.excercisetemplatemethod;

public class Main {
    /**
     * 템플릿 메서드 패턴
     * -> 상위 클래스에서는 뼈대를 결정한다. ( 추상 메서드 + 일반 메서드 )
     * -> 하위 클래스에서는 구체적 내용을 결정한다.
     *
     * -> 따라서 로직을 공통화 할 수 있다. 오류가 발생해도 템플릿 메서드만 수정하면 됨.
     * */

    public static void main(String[] args) {
        AbstractDisplay charDisplay = new CharDisplay('H');
        AbstractDisplay stringDisplay = new StringDisplay("Hello, world");

        charDisplay.display();
        stringDisplay.display();

    }
}
