package cn.zsza.java8;

import cn.zsza.domain.Student;
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
        // Consumer<String> print = str -> System.out.println(str);
        Consumer<String> print = System.out::println;
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
        // 上面代码可以简写成如下
        intList.forEach(intConsumer);
    }

    /**
     * 一个List存放Student对象,然后给每个学生的成绩加2分
     */
    @Test
    public void test3(){
        Student stu1 = new Student();
        stu1.setName("小红");
        stu1.setId(122);
        stu1.setScore(88);

        Student stu2 = new Student();
        stu2.setName("小白");
        stu2.setId(123);
        stu2.setScore(78);

        List<Student> studentList = Arrays.asList(stu1, stu2);
        System.out.println("before consumer studentList:" + studentList);

        // java8之前的实现
        System.out.println("before java8...");
        for(Student stu: studentList){
            stu.setScore(stu.getScore() + 2);
        }
        // java8的实现
        Consumer<Student> stuConsumer = stu -> stu.setScore(stu.getScore() + 2);
        studentList.stream().forEach(stu -> stuConsumer.accept(stu));

        // 上面两行代码等同于下面一行
//        studentList.stream().forEach(stu -> stu.setScore(stu.getScore() + 2));
        System.out.println("after consumer studentList:" + studentList);
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
