package cn.zsza.map;


import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapTest {
    /**
     * Map
     *  key: 英文名
     *  value: 名字的长度
     * computeIfAbsent(K key,
     *             Function<? super K, ? extends V> mappingFunction)方法实现:
     *  先判断key是否存在于Map，如果不存在，则进行put操作，并返回对应的value值，
     *  否则直接返回key对应的value值!
     */
    @Test
    public void testComputeIfAbsent(){
        Map<String, Integer> map = new HashMap<>();
        map.put("amy", 3);
        map.put("jack", 4);
        map.put("john", 4);

        Function<String, Integer> fnc = String::length;
        /**
         * jack存在于map中,所以res返回4
         */
        Integer res = map.computeIfAbsent("jack", fnc);
        System.out.println(res);
        System.out.println(map);

        Integer sheroLength = map.computeIfAbsent("shero", fnc);
        System.out.println(sheroLength);
        System.out.println(map);
    }
    /**
     * putIfAbsent(K key, V value)方法实现:
     *  如果key存在，则返回对应的value值，否则进行put操作，并返回value值
     */
    @Test
    public void testPutIfAbsent(){
        Map<String, Integer> map = new HashMap<>();
        map.put("amy", 12);
        map.put("jack", 14);

        System.out.println(map.put("amy", 19));

        map.putIfAbsent("Jenny", 24);
        System.out.println("map:" + map);

    }
}
