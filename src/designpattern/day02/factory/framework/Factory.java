package designpattern.day02.factory.framework;

public abstract class Factory {
    /**
     * Template Method Pattern
     *
     * - Factory Pattern
     * - create를 new 가 아닌 create를 통해서 수행하게함.
     * - 즉 인스턴스 생성을 Factory 클래스를 통해서만 진행.
     * */
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}
