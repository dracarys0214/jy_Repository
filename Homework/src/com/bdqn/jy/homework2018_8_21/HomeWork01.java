package com.bdqn.jy.homework2018_8_21;

import java.util.Scanner;

public class HomeWork01 {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String b;		
		do {
			System.out.println("���ţ��㰮����");
			b = in.next();
		} while (!b.equalsIgnoreCase("��"));

		System.out.println("�����������!");
		in.close();
	}

}
