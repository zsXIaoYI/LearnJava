package cn.zsza.java8.appleDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * package: cn.zsza.java8.appleDemo
 * Time: 2020/4/13 20:43
 * Author: zs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Apple {
	private Integer weight;
	private String color;


	public Apple(Integer weight) {
		this.weight = weight;
	}

	/**
	 * 判断苹果是否为绿色
	 * @return
	 */
	public boolean isGreenApple(){
		return "green".equals(this.color);
	}
}
