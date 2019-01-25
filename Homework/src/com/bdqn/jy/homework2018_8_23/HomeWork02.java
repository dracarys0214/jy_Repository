/**
 * adadasas
 */
package com.bdqn.jy.homework2018_8_23;

import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jy 2018年8月24日下午2:23:14
 *
 */
public class HomeWork02 {

	public static void main(String[] args) {
		int oldArr[] = { 1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5 };
		int[] newArr = new int[12];// 新数组长度=oldArr.length-0的个数
		int num = 0;// 需去除的数字
		// 方法一
//		for (int i = 0, j = 0; i < oldArr.length - 4; i++, j++) { // j为游标，与i同步
//			while (num == oldArr[j]) { // oldArr元素为0时
//				j++;// 游标右移一位
//			}
//			newArr[i] = oldArr[j];// 赋值
//		}
//		System.out.println(Arrays.toString(newArr));
		// 方法二
		
		for (int i = 0, j = 0; i < oldArr.length - 4; i++) { // j为游标
			while (num == oldArr[i + j]) { // oldArr元素为0时
				j++;// 游标右移一位
			}
			newArr[i] = oldArr[i + j];// 赋值
		}
//		System.out.println(Arrays.toString(newArr));
//		List l=Arrays.asList(oldArr);
//		System.out.println(l.contains(1)); 数字没有 equals 方法
		System.out.println(Arrays.toString(Arrays.copyOf(oldArr, oldArr.length-2)));
		System.out.println(Arrays.equals(oldArr, newArr));
		//Arrays.fill(oldArr, 9);
		Arrays.sort(oldArr);
		int index=Arrays.binarySearch(oldArr, 3);
		System.out.println(index);
		System.out.println(Arrays.toString(oldArr));
		
	}

}
