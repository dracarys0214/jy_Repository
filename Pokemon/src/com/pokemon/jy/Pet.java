package com.pokemon.jy;

/**
 * 宠物小精灵共有属性
 * 
 * @author jy 2018年9月5日下午10:37:11
 *
 */
public abstract class Pet extends Util {
	String name;// 姓名
	int level;// 等级
	int healthPoint;// 生命值
	int magicPoint;// 魔法值
	int attack;// 攻击力
	int defence;// 防御力
	Property property;// 属性
	int empiricalValue;// 经验值
	int intimacy;// 亲密度
	
}

enum Property { // 属性（枚举）
	FIRE, WATER, ELECTRICITY, GRASS // 火 水 电 草
}
