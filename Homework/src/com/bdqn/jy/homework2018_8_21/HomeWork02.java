package com.bdqn.jy.homework2018_8_21;

import java.util.Scanner;

public class HomeWork02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a =-1;
		do {
			System.out.println("����һ��1-7��Χ�����֣�����0�˳�����:");

			if (in.hasNextInt()) {
				a = in.nextInt();
			} else {
				String c = in.next();
				System.out.println("���������" + c + "\t����������!");
			}
			if (a == 0) {
				break;
			}
			switch (a) {
			case 1:
				System.out.println("����һ");
				break;
			case 2:
				System.out.println("���ڶ�");
				break;
			case 3:
				System.out.println("������");
				break;
			case 4:
				System.out.println("������");
				break;
			case 5:
				System.out.println("������");
				break;
			case 6:
				System.out.println("������");
				break;
			case 7:
				System.out.println("������");

			default:
				System.out.println("�������ִ�������������!");
				break;

			}

		} while (true);

		System.out.println("�������!");
		in.close();
	}

}
