package cn.zsza.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();

        map.put("name", "张松");
        map.put("age", 12);

        System.out.println(map);

    }


}
