package cn.zsza.str;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
/**
 * package: cn.zsza.str
 * Time: 2021/6/16 15:18
 * Author: zs
 */
public class StringJoinerTest {
    /**
     * 使用StringJoiner() 以某个分隔符分隔数组
     */
    @Test
    public void testStringJoiner() {
        String[] names = {"Bob", "Jack", "Amy"};
        StringJoiner joiner = new StringJoiner(", ");
        for (String name : names) {
            joiner.add(name);
        }
        System.out.println(joiner.toString());
        String res = String.join(", ", names);
        System.out.println(res);
    }
    /**
     * 使用Java8完成上述操作
     */
    @Test
    public void testJava8Joiner() {
        List<String> list = ImmutableList.of("aa", "bb", "cc");
        String result = list.stream().map(String::valueOf).collect(Collectors.joining("|"));
        System.out.println(result);
    }
    /**
     * 使用Guava Api完成上述操作
     */
    @Test
    public void testGuavaJoiner() {
        List<String> list = ImmutableList.of("aa", "bb", "cc");
        String result = Joiner.on(", ").join(list);
        System.out.println(result);
    }
}
