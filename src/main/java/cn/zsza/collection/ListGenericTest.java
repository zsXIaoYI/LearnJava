package cn.zsza.collection;

import cn.zsza.domain.U;
import cn.zsza.domain.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By zhangsong
 * 20:06 2020/2/26
 */
public class ListGenericTest {
	/**
	 * 集合泛型操作
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		List<Number> numberList = new ArrayList<>();
		intList.add(11);
		intList.add(22);

		numberList.add(1);
		numberList.add(2);

		getUperNumber(intList);
		getUperNumber(numberList);

		/**
		 * getUperNumber对strList的迭代，在编译上都通过不了
		 */
		List<String> strList = new ArrayList<>();
		strList.add("xx");
		strList.add("yy");

		getData(strList);

		System.out.println("**************分隔符*************");

		U u1 = new U();
		u1.setId(11);

		U u2 = new U();
		u2.setId(12);

		printObjectList(Arrays.asList(u1, u2));

	}

	public static void getData(List<?> data){
		data.forEach(System.out::println);
//		data.stream().forEach(e -> System.out.println(e));
	}
	/**
	 * data参数指定的泛型只能为Number类型或它的子类
	 * @param data
	 */
	public static void getUperNumber(List<? extends Number> data){
		data.stream().forEach(e -> System.out.println(e));
	}
	/**
	 * list参数指定的泛型只能为User类型或它的父类
	 * @param list
	 */
	public static void printObjectList(List<? super User> list){
		list.stream().forEach(e -> System.out.println(e));
	}
}
