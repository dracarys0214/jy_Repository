package homework2018_9_7;

import java.util.Scanner;

/**
 * 实用方法
 * 
 * @author jy 2018年9月6日下午3:20:27
 *
 */
public class P {
	static void p(String str) { // 简化输出
		System.out.println(str);
	}

	static Scanner in = new Scanner(System.in);

	static int IntIn(int i, int j) {
		int m;
		while (true) {
			if (in.hasNextInt()) {
				m = in.nextInt();
				if (m > i && m < j) {
					break;
				}
				p(m + " 输入错误，请重新输入!");
			} else {
				p(in.next() + " 输入错误，请重新输入!");
			}
		}
		return m;
	}

	static void pause(int i) { // 暂停i毫秒
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
