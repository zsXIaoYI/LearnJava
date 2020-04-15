package cn.zsza.java8;

import org.junit.Test;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 16:23
 * Author: zs
 */
public class StreamTest {
    /**
     * 1、anyMatch()：任意一个满足Predicate表达式，则返回true
     * 2、allMatch()：所有的元素满足Predicate表达式，则返回true
     */
    @Test
    public void testMatch(){
        List<Integer> list = Arrays.asList(3, 4, 6, 12, 20);
        boolean result = list.stream().anyMatch(e -> (e * (e + 1) / 4 == 5));
        System.out.println(result);

        boolean result2 = list.stream().allMatch(e -> e >= 2);
        System.out.println(result2);
    }

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
    /**
     * 从1开始，生成1到10之间的自然数
     */
    @Test
    public void test3(){
        List<Integer> intList = Stream
                .iterate(1, x -> x + 1)
                .limit(10).collect(Collectors.toList());
        System.out.println(intList);
    }
    /**
     * IntStream
     * 1、rangeClosed(),[1, 10]
     * 2、range()，[1, 10)
     */
    @Test
    public void testIntStream(){
        IntStream intStream = IntStream.rangeClosed(1, 10);
        intStream.forEach(e -> System.out.println(e));
        System.out.println("............................");

        IntStream.Builder builder = IntStream.builder();
        builder.accept(100);
        // add方法内部调用了accept()方法
        IntStream stream2 = builder
                .add(1)
                .add(2)
                .add(3).build();

        stream2.forEach(System.out::println);
    }
}
