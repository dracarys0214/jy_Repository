package com.bdqn.jy.homework2018_8_20;

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String b = "";
		do {
			System.out.println("����һ��0��2֮�������:");
			int a = -1;
			if (in.hasNextInt()) {
				a = in.nextInt();
			} else {
				String c = in.next();
				System.out.println("���������" + c + "\t����������!");
			}
			switch (a) {
			case 0:
				System.out.println("�������ʯͷ");
				break;
			case 1:
				System.out.println("������Ǽ���");
				break;
			case 2:
				System.out.println("������ǲ�");
				break;
			default:
				System.out.println("�������ִ�������������!");
				break;

			}
			System.out.println("�ش�y�����ظ����Ϲ���,�����������!");

			b = in.next(); // �����in.nextLine(),��ô����� int a=in.nextInt()�Ļس�;

		} while (b.equalsIgnoreCase("y"));

		System.out.println("�����������!");
		in.close();
	}

}
