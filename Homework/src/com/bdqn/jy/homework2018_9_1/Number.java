package com.bdqn.jy.homework2018_9_1;

import java.util.Scanner;

public class Number {

	private int n1, n2;

	public Number() {
		super();
	}

	
	
	
 Number(int n1, int n2) {
		 
		 this.n1 = n1;
		this.n2 = n2;
		addition();
		subtration();
		multiplication();
		division();
		
	}

	 void addition() {
		
		System.out.println(n1 + "+" + n2 + "=" + (n1 + n2));	
	}

	public void subtration() {
		System.out.println(n1 + "-" + n2 + "=" + (n1 - n2));
	}

	public void multiplication() {
		System.out.println(n1 + "*" + n2 + "=" + (n1 * n2));
	}

	public void division() {
		if (n2 == 0) {
			System.out.println("0不能作为除数!");
			return;
		}
		System.out.println(n1 + "/" + n2 + "=" + (n1 / n2));
	}

	public static void main(String[] args) {
		
	
	
		Scanner in = new Scanner(System.in);
		int n1, n2;

		while (true) {
			System.out.println("请输入第一个整数:");
			if (in.hasNextInt()) {
				n1 = in.nextInt();
				break;
			} else {
				String s = in.next();
				System.out.println(s + ":输入错误，请重新输入!");
			}
		}

		while (true) {
			System.out.println("请输入第二个整数:");
			if (in.hasNextInt()) {
				n2 = in.nextInt();
				break;
			} else {
				String s = in.next();
				System.out.println(s + ":输入错误，请重新输入!");
			}
		}
		Number duixiang=new Number(n1, n2);
		

	
		in.close();
	}


}
