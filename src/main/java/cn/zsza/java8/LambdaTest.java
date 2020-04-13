package cn.zsza.java8;

import cn.zsza.java8.appleDemo.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/13 20:50
 * Author: zs
 */
public class LambdaTest {

    public static void main(String[] args) {
        /**
         * String::length
         * (String s) -> {return s.length();}
         * (String s) -> s.length()
         * s -> s.length()
         */
        Function<String,Integer> fn = s -> s.length();
        List<Integer> list = map(Arrays.asList("java", "php", "like"), fn);
        System.out.println("list中每个元素的长度:" + list);

        // a1每调用get()方法一次,就会生成一个对象
        Supplier<Apple> a1 = Apple::new;
        System.out.println(a1.get() == a1.get());

        /**
         * 等同于Function<Integer,Apple> ff = (weight) -> new Apple(weight);
         */
        Function<Integer,Apple> f = Apple::new;
        Apple a2 = f.apply(10);
        System.out.println(a2);
        /**
         *  BiFunction<Integer, String, Apple> biFunction = Apple::new;
         */
        BiFunction<Integer, String, Apple> biFunction = (weight, color) -> new Apple(weight, color);
        Apple redApple = biFunction.apply(20, "red");
        System.out.println(redApple);

        /**
         * 使用Apple::new
         */
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> appleList = map(weights, Apple::new);
        System.out.println(appleList);
    }
    /**
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        list.stream().forEach(l -> result.add(f.apply(l)));
        return result;
    }
}


