package com.bdqn.jy.homework2018_9_3;

import java.util.Scanner;

public class TestBook {

	public static void main(String[] args) {
		Book b = new Book();
		Scanner in = new Scanner(System.in);
		System.out.println("������̲���:");
		b.setTitle(in.next());
		System.out.println("������ҳ��:");
		b.setPageNum(in.nextInt());
		b.detail();
		in.close();
	}

}
