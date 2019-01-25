package com.bdqn.jy.homework2018_8_21;

import java.util.Scanner;

public class HomeWork02 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a =-1;
		do {
			System.out.println("输入一个1-7范围的数字，输入0退出程序:");

			if (in.hasNextInt()) {
				a = in.nextInt();
			} else {
				String c = in.next();
				System.out.println("你输入的是" + c + "\t请输入整数!");
			}
			if (a == 0) {
				break;
			}
			switch (a) {
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
			case 4:
				System.out.println("星期四");
				break;
			case 5:
				System.out.println("星期五");
				break;
			case 6:
				System.out.println("星期六");
				break;
			case 7:
				System.out.println("星期日");

			default:
				System.out.println("输入数字错误，请重新输入!");
				break;

			}

		} while (true);

		System.out.println("程序结束!");
		in.close();
	}

}
