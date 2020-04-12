package cn.zsza.java8;

import java.util.*;
import java.util.function.Function;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 11:41
 * Author: zs
 */

public class FunctionDemo2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("node", "c++", "java", "javascript");

        Map<String, Integer> strLengthMap = convertListToMap(list, String::length);
        System.out.println(strLengthMap);

        List<Integer> strLengthList = convertListToStrLength(list, String::length);
        System.out.println(strLengthList);
    }

    /**
     * 统计一个类型为字符串的List中每个元素的长度,并返回Map
     *  key：字符串
     *  value：字符串的长度
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> function){
        Map<T, R> resultMap = new HashMap<>();
        list.stream().forEach(e -> resultMap.put(e, function.apply(e)));
        return resultMap;
    }
    /**
     * 统计一个类型为字符串的List中每个元素的长度,并把该长度装入一个新的List返回
     * @param list
     * @param function
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> convertListToStrLength(List<T> list,
                                                        Function<T, R> function){
        List<R> resultList = new ArrayList<>();
        list.stream().forEach(e -> resultList.add(function.apply(e)));
        return resultList;
    }
}
