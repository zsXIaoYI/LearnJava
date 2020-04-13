package cn.zsza.java8.appleDemo;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * package: cn.zsza.java8.appleDemo
 * Time: 2020/4/13 20:43
 * Author: zs
 */
public class AppleFilter {
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
				new Apple(155, "green"),
				new Apple(120, "red"),new Apple(50, "red"));

		inventory.stream().forEach(System.out::println);
		inventory.stream().forEach(apple -> System.out.println(apple));

		System.out.println(".............");

		List<Apple> greenAppleList = inventory.stream().filter(Apple::isGreenApple).collect(Collectors.toList());
		System.out.println("green:" + greenAppleList);
		/**
		 * 按照weight进行倒序排序
		 */
		inventory.sort(Comparator.comparing(Apple::getWeight,Comparator.reverseOrder()));
		System.out.println(inventory);

		List<Apple> apples = filterApples(inventory,(Apple p) ->
				p.getWeight() > 150 && "green".equals(p.getColor()));
		System.out.println(apples);

		/**
		 * Java8
		 */
		List<Apple> collect = inventory.stream()
				.filter(apple ->
						"green".equals(apple.getColor()))
				.collect(Collectors.toList());
		System.out.println(collect);
		/**
		 * 先进行过滤，然后再按照颜色分组
		 */
		Map<String, List<Apple>> listMap = inventory.stream()
				.filter(apple -> apple.getWeight() > 70)
				.collect(Collectors.groupingBy(Apple::getColor));
		System.out.println(listMap);
		/**
		 * Java8顺序和并行地从一个列表里筛选出大于70的苹果
		 */
		inventory.stream()
				.filter(apple -> apple.getWeight() > 70)
				.collect(Collectors.toList());

		inventory.parallelStream()
				.filter(apple -> apple.getWeight() > 70)
				.collect(Collectors.toList());
		/**
		 * 匿名内部类
		 */
		filterApplesSelf(inventory, new ApplePredicate() {
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor());
			}
		});
		/**
		 * Lambda写法
		 */
		filterApplesSelf(inventory, apple -> "red".equals(apple.getColor()));


		/**
		 * Predicate用法
		 */
		Predicate<Apple> p = apple -> "green".equals(apple.getColor());
		Predicate<Apple> negate = p.negate();
		List<Apple> notGreen = filterApples(inventory, negate);
		System.out.println("notGreen:" + notGreen);


	}
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
		List<Apple> result = new ArrayList<>();
//		for (Apple apple : inventory){
//			if (p.test(apple)){
//				result.add(apple);
//			}
//		}
		inventory.stream().forEach(apple -> {
			if (p.test(apple)){
				result.add(apple);
			}
		});
		return result;
	}


	public static List<Apple> filterApplesSelf(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory){
			if (p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	}
	/**
	 * 泛型化的
	 * @param sourceList
	 * @param p
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> filterObject(List<T> sourceList,Predicate<T> p){
		List<T> result = new ArrayList<>();
		sourceList.stream().forEach(t -> {
			if (p.test(t)){
				result.add(t);
			}
		});
		return result;
	}

	public static boolean isGreenApple(Apple apple){
		return "green".equals(apple.getColor());
	}

	public interface ApplePredicate{
		boolean test(Apple apple);
	}

//	public interface Predicate<T>{
//
//		boolean test(T t);
//	}
}
