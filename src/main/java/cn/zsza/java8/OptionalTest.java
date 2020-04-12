package cn.zsza.java8;

import cn.zsza.domain.User;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Optional;

public class OptionalTest {
    /**
     * 1、Optional.of() 接收一个非空对象，如果接收null,则会触发空指针异常
     * 2、Optional.ofNullable()接收一个null，返回一个空的Optional对象
     */
    @Test
    public void test1(){
        Optional<String> opt1 = Optional.of("hello");
        System.out.println(opt1.get());

        Optional<Object> opt2 = Optional.ofNullable(null);
        System.out.println(opt2);
    }
    /**
     * ofNullable()接收一个User对象,如果User对象不为null,则以下业务逻辑能顺利执行;
     * 为了防止获取User对象的名字,则用nameOpt.isPresent()加以判断
     */
    @Test
    public void test2(){
        User user = new User();
        user.setId(11);
        user.setName("小白");
        /**
         * 如果Optional.ofNullable()接收一个null对象，则userOpt和nameOpt都返回一个Optional对象
         */
        Optional<User> userOpt = Optional.ofNullable(user);
        Optional<String> nameOpt = userOpt.map(e -> e.getName());
        if (nameOpt.isPresent()){
            assertEquals("小白",nameOpt.get());
        }
    }
}
