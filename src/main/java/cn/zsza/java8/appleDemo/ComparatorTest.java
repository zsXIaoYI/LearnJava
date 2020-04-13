package cn.zsza.java8.appleDemo;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * package: cn.zsza.java8.appleDemo
 * Time: 2020/4/13 20:43
 * Author: zs
 */
public class ComparatorTest {
	private static List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
			  new Apple(155, "green"),
			  new Apple(120, "red"),new Apple(50, "red"));

	public static class AppleComparator implements Comparator<Apple>{
		@Override
		public int compare(Apple o1, Apple o2) {
			return o1.getWeight().compareTo(o2.getWeight());
		}
	}
	public static void main(String[] args) {
		/**
		 * 第一种：传递一个比较器
		 */
		inventory.sort(new AppleComparator());
		/**
		 * 第二种使用匿名内部类
		 */
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		/**
		 * 第三种使用Lambda表达式
		 */
		inventory.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
		inventory.sort(comparing(Apple::getWeight));
		inventory.sort(comparing( apple -> apple.getWeight()));
		/**
		 * 第四种使用方法引用
		 * 按照重量递减排序，当重量递减时，按照颜色排序
		 */
		inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
	}
}
