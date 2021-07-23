package effectivejava.chapter3.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomHashKeyObject {

    private final int value, count;
    private int hash;

    public CustomHashKeyObject(int value, int count) {
        this.value = value;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomHashKeyObject)) return false;
        CustomHashKeyObject that = (CustomHashKeyObject) o;
        return value == that.value && count == that.count;
    }

    @Override
    public int hashCode() {
//        int h = hash;
//        if (h == 0) {
//            System.out.println("hashCode generate");
//            h = Objects.hash(value, count);
//            hash = h;
//        }
//        return h;

        System.out.println("hashCode generate"); //3번 출력
        return Objects.hash(value, count);
    }

    /* 캐싱, hashCode 메서드내 주석 -> hashCode generate: 2번 출력*/
    public static void main(String[] args) {
        Map<CustomHashKeyObject, Object> map = new HashMap<>();

        CustomHashKeyObject o1 = new CustomHashKeyObject(10, 2);

        map.put(o1, "102");
        String value1 = (String) map.get(o1);
        String value2 = (String) map.get(new CustomHashKeyObject(10, 2));

        System.out.println(value1);
        System.out.println(value2);
    }
}