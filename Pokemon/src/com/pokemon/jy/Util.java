package com.pokemon.jy;
import java.util.Scanner;
/**
 * ʵ�÷���
 * @author jy 2018��9��6������3:20:27
 *
 */
public class Util {
	void p(String str) { // �����
		System.out.println(str);
	}

	Scanner in = new Scanner(System.in);

	int IntIn(int i, int j) {
		int m;
		while (true) {
			if (in.hasNextInt()) {
				m = in.nextInt();
				if (m > i && m < j) {
					break;
				}
				p(m + " �����������������!");
			} else {
				p(in.next() + " �����������������!");
			}
		}
		return m;
	}

	void pause(int i) { // ��ͣi����
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
}
