package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestReflect {
	List<User> list = new ArrayList<>();// 存储类对象
	String[] classNames = new String[10];// 10个类名的字符串
	int id[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	int[] age = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 10 };
	String[] name = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
	Date[] birthday = { new Date(), new Date(), new Date(), new Date(),
			new Date(), new Date(), new Date(), new Date(), new Date(),
			new Date() };

	public static void main(String[] args) throws Exception {
		// args[0].toCharArray()
		// TODO Auto-generated method stub
		TestReflect tr = new TestReflect();
		for (int i = 0; i < 10; i++) {

			User user = tr.getInstance("reflection.User", tr.id[i], tr.age[i],
					tr.name[i]);
			tr.list.add(user);// 创建10个对象存到
		}
		for (User u : tr.list) {
			System.out.println(u);
		}

	}

	public User getInstance(String className, Object... obj) throws Exception {

		@SuppressWarnings("unchecked")
		Class<User> clazz = (Class<User>) Class.forName(className);
		Field[] f = clazz.getDeclaredFields();
		User u = clazz.newInstance();

		for (int i = 0; i < obj.length; i++) {
			Method m = clazz.getDeclaredMethod(
					"set" + toFirstUpper(f[i].getName()), f[i].getType());
			m.invoke(u, obj[i]);
		}

		return u;

	}

	String toFirstUpper(String s) {
		return (char) (s.charAt(0) - 32) + s.substring(1);
	}

}
