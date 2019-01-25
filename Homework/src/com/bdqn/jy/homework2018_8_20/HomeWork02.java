package com.bdqn.jy.homework2018_8_20;

public class HomeWork02 {

	public static void main(String[] args) {
		int odd = 0, even = 0;
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
		System.out.println("1-100奇数和:" + odd + "\n1-100偶数和:" + even);
		System.out.println("程序结束运行!");
	}

}
