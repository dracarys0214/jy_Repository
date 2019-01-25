package com.bdqn.jy.homework2018_8_21;

import java.util.Scanner;

public class HomeWork01 {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String b;		
		do {
			System.out.println("老婆，你爱我吗？");
			b = in.next();
		} while (!b.equalsIgnoreCase("爱"));

		System.out.println("程序结束运行!");
		in.close();
	}

}
