package com.bdqn.jy.homework2018_8_21;

import java.util.Scanner;

public class HomeWork03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("您想要几行数字?(1-9)");
			int a=-99;
			if (in.hasNextInt()) {
				a = in.nextInt();
			} else {
				System.out.println("你输入的是" + in.next());
			}
			if (a < 1 || a > 9) {
				System.out.println("请重新输入1-9的整数!");
			} else {
				for (int i = 1; i <= a; i++) {
					for (int j = 0; j < a - i; j++) {
						System.out.print(" ");
					}

					for (int j = 0; j < 2 * i - 1; j++) {
						System.out.print(i);
					}
					System.out.println();
				}
			}
			
		}
	}
}
