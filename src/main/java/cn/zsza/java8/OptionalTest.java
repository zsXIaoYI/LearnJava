package cn.zsza.java8;

import cn.zsza.domain.User;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
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
     * 当接收的参数不确定是否为null时,用ofNullable()
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
    /**
     * ifPresent()方法
     */
    @Test
    public void test3(){
        User user = new User();
        user.setId(11);
        user.setName("mike");

        Optional<User> usrOpt = Optional.ofNullable(user);
        List<User> userList = new ArrayList<>();
        usrOpt.ifPresent(e -> userList.add(e));
        System.out.println(userList);
    }
    /**
     * orElse()方法,如果strOpt对象不为空,则返回strOpt的内容,否则返回orElse()对象的值
     */
    @Test
    public void testOrElse(){
        Optional<String> strOpt = Optional.ofNullable("hello");
        String res = strOpt.orElse("kelly");
        System.out.println(res);
    }
    /**
     * userOpt.map(User::getName)返回一个Optional对象,后面可以继续连接map，组成链式操作
     *
     */
    @Test
    public void testChain(){
        User user = new User();
        user.setId(123);
        user.setName("jack");
        /**
         * 当user对象为null时,则返回default Name
         */
        Optional<User> userOpt = Optional.ofNullable(user);
        String defaultName = userOpt.map(User::getName)
                .map(String::toUpperCase).orElse("default Name");
        System.out.println(defaultName);
    }
    /**
     * flatMap操作和Stream中的flatMap操作类似
     */
    @Test
    public void testFlatMap(){
        Optional<String> male = Optional.of("male");
        Optional<Optional<String>> maleOpt = Optional.of(male);

        Optional<String> resultOpt = maleOpt.flatMap(e -> e.map(String::toUpperCase));
        System.out.println(resultOpt.get());
    }
}
