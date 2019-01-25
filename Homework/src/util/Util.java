package util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String str = "    a";
		System.out.println(notNull(str));
		System.out.println(m("asddas   ffd"));
		System.out.println(time(new Date()));
		System.out.println(reTime(new Date()));

		for (String temp : rename("a1.doca2.doca3.doca4.doca5.doca6.c")) {
			System.out.print(temp + "\t");
		}
		System.out.println("\n##########################");

		System.out.println(remove("#sa*s@#df**1#&*&&$@we#q&e#"));

		String c = "啊大大带哦哦匹配吗，吗asdasda231313！！&！**！（（！";

		System.out.println(code(c));
		System.out.println(decode(code(c)));
	}

	/**
	 * null和""返回false
	 */
	static boolean notNull(String str) {
		if (str == null) {
			return false;
		}
		// if (str.replace(" ", "").equals("")) {// 去掉所有空格
		// if (str.trim().equals("")) {
		if (str.trim().length() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * String去重
	 */
	static String m(String str) {
		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			if (i == str.indexOf(c[i])) {// str.indexOf(c[i])返回第一个c[i]值的位置
				sb.append(c[i]);
			}
		}
		return sb.toString();

	}

	/**
	 * 去掉所有包含，返回个数
	 */
	static int num(String str, String s) {
		int i = 0;
		while (true) {
			if (str.contains(s)) {
				i++;
				str = str.replaceFirst(s, "");
				System.out.println(str);
				continue;
			}
			break;
		}
		return i;
	}

	/**
	 * Date返回时间
	 */
	static String time(Date date) {
		if (date == null) {
			date = new Date();
		}
		return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(date);
	}

	/**
	 * 时间去掉格式只留数字
	 */
	static String reTime(Date date) {
		//return time(date).replace("-", "").replace(" ", "").replace(":", "");
		if (date == null) {
			date = new Date();
		}
		return new SimpleDateFormat("yyyymmddhhmmss").format(date);
		
	}

	/**
	 * 重命名
	 */
	static String[] rename(String str) {
		String[] file = str.split(".doc");
		for (int i = 0; i < file.length; i++) {
			file[i] = "bdqn-" + System.currentTimeMillis() + ".doc";
		}
		return file;
	}

	/**
	 * 去掉特殊符号#*&
	 */
	static String remove(String str) {
		return str.replace("#", "").replace("&", "").replace("*", "");
	}

	/**
	 * 加密 首尾一对，往中间加，比如 123456——>615243,Unicode+100
	 */
	static String code(String str) {
		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		if (str.length() % 2 == 0) {
			for (int i = 0; i < str.length() >> 1; i++) {
				sb.append((char) (c[str.length() - i - 1] + 100));
				sb.append((char) (c[i] + 100));
			}
		} else {
			int i = 0;
			for (; i < str.length() >> 1; i++) {
				sb.append((char) (c[str.length() - i - 1] + 100));
				sb.append((char) (c[i] + 100));
			}
			sb.append((char) (c[i] + 100));
		}
		return sb.toString();
	}

	/**
	 * 解密
	 */
	static String decode(String str) {
		char[] c = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {

			if (i % 2 == 1) {
				sb.append((char) (c[i] - 100));

			}
		}
		for (int i = c.length - 1; i > -1; i--) {

			if (i % 2 == 0) {
				sb.append((char) (c[i] - 100));

			}
		}
		return sb.toString();
	}
}
