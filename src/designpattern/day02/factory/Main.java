package designpattern.day02.factory;

import designpattern.day02.factory.framework.Factory;
import designpattern.day02.factory.framework.Product;
import designpattern.day02.factory.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        // 구체적인 클래스 이름에 대한 new 를 호출하지 않아도 됨.
        Product card1 = factory.create("Youngjin Kim");
        Product card2 = factory.create("Youngjin2");
        Product card3 = factory.create("Youngjin3");
        card1.use();
        card2.use();
        card3.use();
        /**
         * 연습문제 풀기
         * */
    }
}
