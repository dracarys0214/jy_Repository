package com.bdqn.jy.homework;

import java.util.Scanner;

public class Capital {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("������һ����ĸ:");

		String s = input.nextLine();

		char[] chars = s.toCharArray();

		char letter = chars[0];
		if (letter >= 'a' && letter <= 'z') {
			letter -= 32;

			System.out.println("��д��ĸ:" + letter + "\r");
			// Сд��ĸ��ascllֵΪ97-122
			// ��д��ĸ��ascllֵΪ65-90
			System.out.println("������һ����ĸ��\n");

			char zimu = input.next().charAt(0);
			if (zimu >= 97 && zimu <= 122) { // �ж��Ƿ���Сд��ĸ
				System.err.println("����ĸ��Сд��ĸ");
				zimu = (char) (zimu - 32); // �����Сд��ĸ�� ����ת���ɴ�д��ĸ
				System.err.println("ת��֮��Ĵ�д��ĸ�ǣ�" + zimu);
			} else {
				System.out.println("����ĸ����Сд��ĸ��");
			}
		}
		input.close();
	}
}
