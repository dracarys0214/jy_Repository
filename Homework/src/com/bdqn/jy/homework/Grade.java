package com.bdqn.jy.homework;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int score = -1;
			System.out.println("请输入一个成绩:");
			if (input.hasNextInt()) {
				score = input.nextInt();
			} else {
				String c = input.next();
				System.out.println("你输入的是" + c + "\t请输入整数!");

			}

			String grade;

			if (score == 100) {
				grade = "优秀";
				System.out.println("等级:" + grade + "\r");
			} else if (score >= 0 && score < 100) {
				int num = score / 10 % 10;
				switch (num) {
				case 9:
					grade = "优秀";
					break;
				case 8:
					grade = "良好";
					break;
				case 7:
					grade = "中等";
					break;
				case 6:
					grade = "及格";
					break;
				default:
					grade = "不及格";
					break;
				}

				System.out.println("等级:" + grade + "\r");
			} else {
				System.out.println("输入错误，请重新输入!");
			}
		}
	}
}
