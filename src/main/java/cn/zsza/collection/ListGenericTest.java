package cn.zsza.collection;

import java.util.ArrayList;
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
}
