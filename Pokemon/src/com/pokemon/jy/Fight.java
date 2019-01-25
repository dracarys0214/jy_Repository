package com.pokemon.jy;
/**
 * 战斗场景
 * @author jy 2018年9月6日下午3:21:30
 *
 */
public class Fight extends Util {
	Pet p1, p2;
	int temp1, temp2;

	public Fight(Pet p1, Pet p2) {// p1我方，p2敌方
		super();
		this.p1 = p1;
		this.p2 = p2;
		temp1 = p1.attack; // 临时存放p1 p2攻击力
		temp2 = p2.attack;
	}

	void fight() { // 我方先攻
		jugde();
		do {
			fight1();
			if (p2.healthPoint <= 0) {
				p2.healthPoint = 0;
				p1.empiricalValue += (p2.empiricalValue / 3); // 获得对手的3分之一经验值
				p1.intimacy += 2;// 亲密度+2
				p(p1.name + "胜利了!经验+" + p2.empiricalValue / 3 + "点，亲密度+2点");
				if (p1.empiricalValue >= (p1.level + 1) * (p1.level + 1) * 100) {// 如果p1经验值超过下一等级的，则升级
					p(p1.name + "升级了!");
					int level = p1.level + 1;
					int intimacy = p1.intimacy;
					String name = p1.name;
					if (Master.own[0].name.contains("皮卡丘")) {
						Master.own[0] = new Pikachu(name, level, intimacy); // 新建一个新的level+1的宠物
					} else if (Master.own[0].name.contains("小火龙")) {
						Master.own[0] = new Pikachu(name, level, intimacy);
					} else if (Master.own[0].name.contains("妙蛙种子")) {
						Master.own[0] = new Bulbasaur(name, level, intimacy);
					} else {
						Master.own[0] = new Squirtle(name, level, intimacy);
					}
				}
				break;
			}
			fight2();
			if (p1.healthPoint <= 0) {
				p1.healthPoint = 0;
				p1.intimacy -= 1;
				p("你输了!亲密度-1点");
				break;
			}
		} while (true);
		p1.attack = temp1;// 返回攻击力
		p2.attack = temp2;

	}

	void fight1() { // p1攻击
		int r1 = p1.attack > p2.defence ? p1.attack // 对方攻击结果
				- p2.defence : 0;
		p2.healthPoint -= r1;
		p(p1.name + "发动了攻击，" + p2.name + "受到了" + r1 + "点伤害!");
		pause(1000);// 停1s
	}

	void fight2() { // p2攻击
		int r1 = p2.attack > p1.defence ? p2.attack // 对方攻击结果
				- p1.defence : 0;
		p1.healthPoint -= r1;
		p(p2.name + "发动了攻击，" + p1.name + "受到了" + r1 + "点伤害!");
		pause(1000);// 停1s
	}

	void jugde() { // 属性相克
		if (p1.property == Property.ELECTRICITY) { // 电
			if (p2.property == Property.ELECTRICITY) { // 电 vs 电,p1 1/2功，p2 1/2功
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // 电 vs 水,p1两倍功
				p1.attack *= 2;
			}
			if (p2.property == Property.GRASS) { // 电 vs 草,p1 1/2功
				p1.attack /= 2;
			}
		}

		if (p1.property == Property.FIRE) {// 火
			if (p2.property == Property.ELECTRICITY) { // 火 vs 火,p1 1/2功，p2 1/2功
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // 火 vs 水,p1 1/2功 ,p2两倍功
				p1.attack /= 2;
				p2.attack *= 2;
			}
			if (p2.property == Property.GRASS) { // 火 vs 草,p1 两倍功,p2 1/2功
				p1.attack *= 2;
				p2.attack /= 2;
			}
		}

		if (p1.property == Property.GRASS) {// 草
			if (p2.property == Property.GRASS) { // 草 vs 草,p1 1/2功，p2 1/2功
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // 草 vs 水,p1 两倍功 ,1/2功
				p1.attack *= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.FIRE) { // 草 vs 火,p1 1/2功,p2 两倍功
				p1.attack /= 2;
				p2.attack *= 2;
			}
		}

		if (p1.property == Property.WATER) {// 水
			if (p2.property == Property.WATER) { // 水 vs 水,p1 1/2功，p2 1/2功
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.FIRE) { // 水 vs 火,p1 两倍功 ,1/2功
				p1.attack *= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.GRASS) { // 水 vs 草,p1 1/2功,p2 两倍功
				p1.attack /= 2;
				p2.attack *= 2;
			}
			if (p2.property == Property.ELECTRICITY) { // 水 vs 电, p2 两倍功
				p2.attack *= 2;
			}
		}

	}

}
