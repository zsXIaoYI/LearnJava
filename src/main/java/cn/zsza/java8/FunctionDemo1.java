package cn.zsza.java8;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.function.Function;

/**
 * Function<T, R>
 *  T – Type of the input to the function.
 *  R – Type of the result of the function.
 */
public class FunctionDemo1 {
    /**
     * Input:字符串
     * Output:输出字符串的长度
     */
    @Test
    public void test1(){
        /**
         * 下面String::length可以写成str -> str.length()
         */
        Function<String, Integer> fnc = String::length;
        Integer result = fnc.apply("hello");
        assertEquals(new Integer(5),result);
    }
    /**
     * Function可用andThen连接,组成链式Function
     *  给name前面添加一个"hello, "字符串,然后求总的字符串的长度
     */
    @Test
    public void testChainFunction(){
        String str = "hello, ";
        Function<String, String> fnc = name -> str + name ;
        Function<String, Integer> fnc2 = String::length;

        Integer totalLength = fnc.andThen(fnc2).apply("amy");
        System.out.println(totalLength);
    }
}
