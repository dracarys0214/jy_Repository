package com.bdqn.jy.homework;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			int score = -1;
			System.out.println("������һ���ɼ�:");
			if (input.hasNextInt()) {
				score = input.nextInt();
			} else {
				String c = input.next();
				System.out.println("���������" + c + "\t����������!");

			}

			String grade;

			if (score == 100) {
				grade = "����";
				System.out.println("�ȼ�:" + grade + "\r");
			} else if (score >= 0 && score < 100) {
				int num = score / 10 % 10;
				switch (num) {
				case 9:
					grade = "����";
					break;
				case 8:
					grade = "����";
					break;
				case 7:
					grade = "�е�";
					break;
				case 6:
					grade = "����";
					break;
				default:
					grade = "������";
					break;
				}

				System.out.println("�ȼ�:" + grade + "\r");
			} else {
				System.out.println("�����������������!");
			}
		}
	}
}
