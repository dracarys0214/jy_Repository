package com.pokemon.jy;

/**
 * ����С���鹲������
 * 
 * @author jy 2018��9��5������10:37:11
 *
 */
public abstract class Pet extends Util {
	String name;// ����
	int level;// �ȼ�
	int healthPoint;// ����ֵ
	int magicPoint;// ħ��ֵ
	int attack;// ������
	int defence;// ������
	Property property;// ����
	int empiricalValue;// ����ֵ
	int intimacy;// ���ܶ�
	
}

enum Property { // ���ԣ�ö�٣�
	FIRE, WATER, ELECTRICITY, GRASS // �� ˮ �� ��
}
