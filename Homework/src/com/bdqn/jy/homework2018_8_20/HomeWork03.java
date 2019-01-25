package com.bdqn.jy.homework2018_8_20;

import java.util.Scanner;

public class HomeWork03 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("阶乘计算，请输入大于0的整数:");
		
		int a = 1;
		if(in.hasNextInt()){
			 a = in.nextInt();			
		}else{
			String b=in.next();
			System.out.println("你输入的是" + b + "\t请输入整数!");		}
		
		System.out.println(a + "!=" + factorialSeries(a));
		long fs = 1;
		for (int i = 1; i < a + 1; i++) {
			fs *= i;
		}
		System.out.println(a + "!=" + fs);
		in.close();
		System.out.println("程序结束运行!");
	}

	static long factorialSeries(int a) {

		if (a > 1) {
			return a * factorialSeries(a - 1);
		} else {
			return 1;
		}
	}

}
