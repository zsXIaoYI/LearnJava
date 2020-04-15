package cn.zsza.zz;

/**
 * package: cn.zsza.str
 * Time: 2020/4/15 8:54
 * Author: zs
 */
public class AfterChange {

    public static void main(String[] args) {
        String str = "a";
        changeStr(str);
        System.out.println("after change str:" + str);

        int a = 12;
        changeInt(a);
        System.out.println("after change int:" + a);

        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        changeStringBuilder(sb);
        System.out.println("after change StringBuilder:" + sb.toString());
    }

    private static void changeStringBuilder(StringBuilder sb) {
        sb.append(" ketty");
    }
    /**
     * 值传递:
     *  在方法被调用时，实参通过形参把它的内容副本传入方法内部，此时形参接收到的内容是实参值的一个拷贝
     * @param a
     */
    private static void changeInt(int a) {
        a = 8;

    }

    private static void changeStr(String str) {
        str = "b";
    }
}
