package cn.zsza.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 16:23
 * Author: zs
 */
public class StreamTest {

    @Test
    public void testSorted(){
        List<Integer> list = Arrays.asList(5, 3, 6, 2, 8);
        List<Integer> newList = list.stream()
                .sorted(Comparator.comparing(Integer::intValue))
                .collect(Collectors.toList());

        System.out.println(newList);

    }
    /**
     * list中元素是用逗号分隔的字符串,然后拆分各个元素组成一个Set
     */
    @Test
    public void testFlatMap(){
        String str1 = "21,13,15";
        String str2 = "14,13,16,18";
        List<String> list = Arrays.asList(str1, str2);

        Set<String> strSet = list.stream()
                .flatMap(e -> Arrays.stream(e.split(",")))
                .collect(Collectors.toSet());

        System.out.println(strSet);
    }
}
