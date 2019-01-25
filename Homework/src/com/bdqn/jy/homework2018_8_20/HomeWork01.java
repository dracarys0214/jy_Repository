package com.bdqn.jy.homework2018_8_20;

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String b = "";
		do {
			System.out.println("输入一个0到2之间的整数:");
			int a = -1;
			if (in.hasNextInt()) {
				a = in.nextInt();
			} else {
				String c = in.next();
				System.out.println("你输入的是" + c + "\t请输入整数!");
			}
			switch (a) {
			case 0:
				System.out.println("你出的是石头");
				break;
			case 1:
				System.out.println("你出的是剪刀");
				break;
			case 2:
				System.out.println("你出的是布");
				break;
			default:
				System.out.println("输入数字错误，请重新输入!");
				break;

			}
			System.out.println("回答“y”就重复以上过程,否则结束程序!");

			b = in.next(); // 如果是in.nextLine(),那么会接收 int a=in.nextInt()的回车;

		} while (b.equalsIgnoreCase("y"));

		System.out.println("程序结束运行!");
		in.close();
	}

}
