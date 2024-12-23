package designpattern.day02.singleton;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Triple {

    // 내부에서 미리 private 생성자를 통해 인스턴스를 준비한다.
    private static Map<String, Triple> map = new HashMap<>();

    // 인스턴스에 대한 초기화 필요 시 , static {} 을 사용한다.
    static {
        String[] names = {"ALPHA", "BETA", "GAMMA"};
        Arrays.stream(names).forEach(
                name -> map.put(name, new Triple(name))
        );
    }

    private String name;

    private Triple(String name) {
        System.out.println("The instance " + name + "is created");
        this.name = name;
    }

    // 생성자 대신 getInstance를 public static 하게 구성한다.
    public static Triple getInstance(String name) {
        return map.get(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
