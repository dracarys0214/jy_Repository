package com.bdqn.jy.homework2018_8_23;

import java.util.Scanner;

public class HomeWork01 {
	

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[]a=new int[5];
		for(int i=0;i<a.length;i++){
			System.out.println("�������"+(i+1)+"����:");
			a[i]=in.nextInt();		
		}
		int max=a[0];
		for(int i=0;i<a.length-1;i++){
			if(max<a[i+1]){
				max=a[i+1];
			}
		}
		int secMax=a[0];
		for(int i=0;i<a.length-1;i++){
			if(secMax<a[i+1]&&max!=a[i+1]){
				secMax=a[i+1];
			}
		}
		
		System.out.println("���ֵ:"+max+"\t�ڶ���ֵ:"+secMax);
		in.close();		
	}

}
