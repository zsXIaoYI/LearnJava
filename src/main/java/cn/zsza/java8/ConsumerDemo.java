package cn.zsza.java8;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 20:40
 * Author: zs
 */
public class ConsumerDemo {
    /**
     * accept方法是个void的类型,和Function接口一样，也可以用andThen()进行连接
     */
    @Test
    public void test1(){
        Consumer<String> print = str -> System.out.println(str);
        print.accept("hello.ketty");

        Consumer<String> printLen = str -> System.out.println("字符串长度:" + str.length());
        print.andThen(printLen).accept("netty");
    }
    /**
     * Consumer用于遍历List
     */
    @Test
    public void test2(){
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        Consumer<Integer> intConsumer = x -> System.out.println(x);
        System.out.println("遍历intList:");
        intList.stream().forEach(e -> intConsumer.accept(e));
    }
    /**
     * 对list中元素进行遍历操作的方法
     * @param list
     * @param consumer
     * @param <T>
     */
    public <T> void forEach(List<T> list, Consumer<T> consumer){
        list.stream().forEach(e -> consumer.accept(e));
    }
}
