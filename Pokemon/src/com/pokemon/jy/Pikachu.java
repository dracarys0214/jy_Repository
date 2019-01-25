package com.pokemon.jy;

/**
 * 皮卡丘
 * 
 * @author jy 2018年9月5日下午10:37:44
 *
 */
public class Pikachu extends Pet {

	public Pikachu(String name, int level, int intimacy) { // 初始化皮卡丘属性
		this.name = name;
		this.level = level;
		healthPoint = 100 + level * 10;// 初级为100，每级加10
		magicPoint = 100 + level * 10;// 初级为100，每级加10
		attack = 10 + level;// 初级为10，每级加1
		defence = level;// 初级为1，每级加1
		property = Property.ELECTRICITY;// 电属性
		empiricalValue = level * level * 100; // 每一级的经验
		this.intimacy = intimacy;
	}

}
