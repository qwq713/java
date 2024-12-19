package designpattern.day02.factory.idcard;

import designpattern.day02.factory.framework.Factory;
import designpattern.day02.factory.framework.Product;

public class IDCardFactory extends Factory {
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        System.out.println(product + "을 등록했습니다.");
    }
}
