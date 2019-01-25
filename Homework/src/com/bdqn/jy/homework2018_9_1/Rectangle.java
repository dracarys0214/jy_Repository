package com.bdqn.jy.homework2018_9_1;

import java.util.Scanner;

public class Rectangle {
	int height = 1;
	double width = 1;

	public Rectangle() {
		super();
		perimeter();
		area();
	}

	public Rectangle(double width) {
		super();
		this.width = width;
		perimeter();
		area();
	}

	public Rectangle(int height) {
		super();
		this.height = height;
		perimeter();
		area();
	}

	public Rectangle(double width, int height) {
		super();
		this.width = width;
		this.height = height;
		perimeter();
		area();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int height;

		System.out.println("������߶�(����0��Ĭ��ֵΪ1):");
		while (true) {
			if (in.hasNextInt()) {
				height = in.nextInt();
				if (height == 0) {
					height = 1;
					break;
				}
				if (height > 0) {
					break;
				} else {
					System.out.println(height + ":�����������������!");

				}
			} else {
				String s = in.next();
				System.out.println(s + ":�����������������!");
			}
		}

		double width;
		System.out.println("��������(����0��Ĭ��ֵΪ1):");
		while (true) {
			if (in.hasNextDouble()) {
				width = in.nextDouble();
				if (width == 0) {
					width = 1;
					break;
				}
				if (width > 0) {
					break;
				} else {
					System.out.println(width + ":�����������������!");

				}
			} else {
				String s = in.next();
				System.out.println(s + ":�����������������!");
			}
		}

		new Rectangle(width, height);

		in.close();
	}

	public void perimeter() {
		System.out.println("�ܳ�:" + (width + height) * 2);
	}

	public void area() {
		System.out.println("���:" + width * height);
	}

}
