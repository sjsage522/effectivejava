package effectivejava.chapter2.item6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class KeySetSameInstanceTest {

    @DisplayName("map 객체 하나당 set(adapter) 하나임을 보장한다")
    @Test
    void keySetTest() {
        Map<String, String> map = new HashMap<>();

        map.put("key", "value");

        final Set<String> set1 = map.keySet();
        final Set<String> set2 = map.keySet();

        Assertions.assertEquals(set1, set2);
    }
}
