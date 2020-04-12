package cn.zsza.java8;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 19:47
 * Author: zs
 * 被注解FunctionalInterface标明的接口有且仅有一个抽象方法
 */
@FunctionalInterface
public interface FunctionInterfaceA<T> {

    T apply(T t);

}
