package cn.zsza.java8.compare;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;

/**
 * package: cn.zsza.java8.compare
 * Time: 2020/8/11 21:03
 * Author: zs
 */
public class ListCompare {

    private static List<String> list = new ArrayList<>();

    @Before
    public void addList(){
        list.add("a");
        list.add("c");
        list.add("b");
    }
    @Test
    public void test1(){
        // 自然升序
        // list.sort(): @since 1.8,jdk1.7没该方法
        list.sort(String::compareTo);
        // 降序排列
        list.sort(Comparator.reverseOrder());
        System.out.println("after reverse:" + list);
    }
    @Test
    public void test2(){
        List<String> newList = list.stream()
                .sorted().collect(Collectors.toList());
        System.out.println("newList:" + newList);
        // sorted() 函数里面传入Comparator.reverseOrder(), 进行逆序排序
    }
    @Test
    public void test3(){
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("name", "zs");
        paramMap.put("age", "18");
        paramMap.put("address", "bj");

        Set<Map.Entry<String, String>> entrySet = paramMap.entrySet();
        List<String> keyList = new ArrayList<>();

        entrySet.forEach(e -> {
            keyList.add(e.getKey());
        });
        keyList.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        int size = keyList.size();
        for (int i = 0; i < size; i++){
            String key = keyList.get(i);
            sb.append(key).append("=").append(paramMap.get(key));
            if (i != size - 1){
                sb.append("&");
            }
        }
        System.out.println(sb.toString());

        System.out.println(System.currentTimeMillis());
    }
}
