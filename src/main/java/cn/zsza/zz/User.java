package cn.zsza.zz;

import lombok.Data;
/**
 * Created By zhangsong
 * 22:33 2020/3/21
 */
@Data
public class User {
	private Integer id;

	public static void main(String[] args) {
		User user = new User();
		user.setId(11);

		System.out.println(user);
	}
}
