package com.pokemon.jy;

/**
 * ��������
 * 
 * @author jy 2018��9��5������10:37:44
 *
 */
public class Bulbasaur extends Pet {

	public Bulbasaur(String name, int level, int intimacy) { // ��ʼ������
		this.name = name;
		this.level = level;
		healthPoint = 100 + level * 10;// ����Ϊ100��ÿ����10
		magicPoint = 100 + level * 10;// ����Ϊ100��ÿ����10
		attack = 10 + level;// ����Ϊ10��ÿ����1
		defence = level;// ����Ϊ1��ÿ����1
		property = Property.GRASS;// ������
		empiricalValue = level * level * 100;
		this.intimacy = intimacy;
	}

}
