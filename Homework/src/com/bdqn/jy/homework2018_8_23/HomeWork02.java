/**
 * adadasas
 */
package com.bdqn.jy.homework2018_8_23;

import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author jy 2018��8��24������2:23:14
 *
 */
public class HomeWork02 {

	public static void main(String[] args) {
		int oldArr[] = { 1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5 };
		int[] newArr = new int[12];// �����鳤��=oldArr.length-0�ĸ���
		int num = 0;// ��ȥ��������
		// ����һ
//		for (int i = 0, j = 0; i < oldArr.length - 4; i++, j++) { // jΪ�α꣬��iͬ��
//			while (num == oldArr[j]) { // oldArrԪ��Ϊ0ʱ
//				j++;// �α�����һλ
//			}
//			newArr[i] = oldArr[j];// ��ֵ
//		}
//		System.out.println(Arrays.toString(newArr));
		// ������
		
		for (int i = 0, j = 0; i < oldArr.length - 4; i++) { // jΪ�α�
			while (num == oldArr[i + j]) { // oldArrԪ��Ϊ0ʱ
				j++;// �α�����һλ
			}
			newArr[i] = oldArr[i + j];// ��ֵ
		}
//		System.out.println(Arrays.toString(newArr));
//		List l=Arrays.asList(oldArr);
//		System.out.println(l.contains(1)); ����û�� equals ����
		System.out.println(Arrays.toString(Arrays.copyOf(oldArr, oldArr.length-2)));
		System.out.println(Arrays.equals(oldArr, newArr));
		//Arrays.fill(oldArr, 9);
		Arrays.sort(oldArr);
		int index=Arrays.binarySearch(oldArr, 3);
		System.out.println(index);
		System.out.println(Arrays.toString(oldArr));
		
	}

}
