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
			System.out.println("0������Ϊ����!");
			return;
		}
		System.out.println(n1 + "/" + n2 + "=" + (n1 / n2));
	}

	public static void main(String[] args) {
		
	
	
		Scanner in = new Scanner(System.in);
		int n1, n2;

		while (true) {
			System.out.println("�������һ������:");
			if (in.hasNextInt()) {
				n1 = in.nextInt();
				break;
			} else {
				String s = in.next();
				System.out.println(s + ":�����������������!");
			}
		}

		while (true) {
			System.out.println("������ڶ�������:");
			if (in.hasNextInt()) {
				n2 = in.nextInt();
				break;
			} else {
				String s = in.next();
				System.out.println(s + ":�����������������!");
			}
		}
		Number duixiang=new Number(n1, n2);
		

	
		in.close();
	}


}
