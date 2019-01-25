package com.pokemon.jy;

/**
 * 杰尼龟
 * 
 * @author jy 2018年9月5日下午10:37:44
 *
 */
public class Squirtle extends Pet {

	public Squirtle(String name, int level, int intimacy) { // 初始化属性
		this.name = name;
		this.level = level;
		healthPoint = 100 + level * 10;// 初级为100，每级加10
		magicPoint = 100 + level * 10;// 初级为100，每级加10
		attack = 10 + level;// 初级为10，每级加1
		defence = level;// 初级为1，每级加1
		property = Property.WATER;// 水属性
		this.empiricalValue = level * level * 100;
		this.intimacy = intimacy;
	}

}
