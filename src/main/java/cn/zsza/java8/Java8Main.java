package cn.zsza.java8;

/**
 * package: cn.zsza.java8
 * Time: 2020/4/12 19:58
 * Author: zs
 */
public class Java8Main {
    public static void main(String[] args) {
        FunctionInterfaceA<String> fa = str -> str + " nice";
        String result = fa.apply("ketty");
        System.out.println(result);
    }
}
