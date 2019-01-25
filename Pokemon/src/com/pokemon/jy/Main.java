package com.pokemon.jy;
/**
 * 程序开始主界面
 * @author jy 2018年9月6日下午3:19:57
 *
 */
public class Main extends Util {
	public static void main(String[] args) {
		new Main().homepage();
	}

	void homepage() {
		p("请选择:\n1、开始游戏\n2、载入进度\n3、系统设置\n4、退出游戏");
		switch (IntIn(0, 5)) {
		case 1:
			start();
			break;
		case 2:
			load();
			break;
		case 3:
			set();
			break;
		default:
			exit();
		}
	}

	void start() {
		p("请选择:\n1、领养宠物\n2、喂食\n3、训练\n4、挑战四天王\n5、显示宠物信息");
		switch (IntIn(0, 6)) {
		case 1:
			if (Master.own[0] != null) {
				p("你已领养宠物，无法重复获取!");
				start();
			}
			adopt();
			break;
		case 2:
			if (Master.own[0] == null) {
				p("请先领养宠物!");
				start();
			}
			feed();
			break;
		case 3:
			if (Master.own[0] == null) {
				p("请先领养宠物!");
				start();
			}
			train();
			break;
		case 4:
			if (Master.own[0] == null) {
				p("请先领养宠物!");
				start();
			}
			challenge();
			break;
		default:
			if (Master.own[0] == null) {
				p("你未拥有宠物，请先领养宠物!");
				start();
			}
			show();
			p("输入0返回:");
			IntIn(-1, 1);
			start();
		}
	}

	void adopt() {// 领养宠物
		p("小智你好！我是大木博士，");
		pause(1000);
		p("请选择你的宠物:\n1、皮卡丘(电)\n2、小火龙(火)\n3、妙蛙种子(草)\n4、杰尼龟(水)\n5、我全都要(嘿嘿!)");
		Pet pet = null;
		switch (IntIn(0, 6)) {
		case 1:

			pet = new Pikachu("", 1, 0);
			p("请输入宠物姓名:");
			pet.name = "皮卡丘-" + in.next();

			break;
		case 2:
			pet = new Charmander("", 1, 0);
			p("请输入宠物姓名:");
			pet.name = "小火龙-" + in.next();

			break;
		case 3:
			pet = new Bulbasaur("", 1, 0);
			p("请输入宠物姓名:");
			pet.name = "妙蛙种子-" + in.next();
			break;
		case 4:
			pet = new Squirtle("", 1, 0);
			p("请输入宠物姓名:");
			pet.name = "杰尼龟-" + in.next();
			break;
		default:
			p("大木博士给了你一巴掌，卒!");
			start();
		}
		Master.own[0] = pet;
		p("为了阻止黑暗四天王，维护世界和平，请带上" + pet.name + "踏上新的征途吧!");
		p("输入0返回:");
		IntIn(-1, 1);
		start();
	}

	void feed() {// 喂食

		p("请选择食物:\n1、糖果(生命值+20%，魔法值+20%)\n2、树果(生命值+50%，魔法值+50%)\n3、饼干(生命值+80%，魔法值+80%)\n4、仙豆(生命值+100%，魔法值+100%)");
		switch (IntIn(0, 5)) {
		case 1:
			Master.own[0].healthPoint = Master.own[0].healthPoint < 80 + Master.own[0].level * 8 ? Master.own[0].healthPoint
					+ 20 + Master.own[0].level * 2
					: 100 + Master.own[0].level * 10;
			Master.own[0].magicPoint = Master.own[0].magicPoint < 80 + Master.own[0].level * 8 ? Master.own[0].magicPoint
					+ 20 + Master.own[0].level * 2
					: 100 + Master.own[0].level * 10;
			Master.own[0].intimacy = Master.own[0].intimacy < 98 ? Master.own[0].intimacy + 2
					: 100;
			break;
		case 2:
			Master.own[0].healthPoint = Master.own[0].healthPoint < 50 + Master.own[0].level * 5 ? Master.own[0].healthPoint
					+ 50 + Master.own[0].level * 5
					: 100 + Master.own[0].level * 10;
			Master.own[0].magicPoint = Master.own[0].magicPoint < 50 + Master.own[0].level * 5 ? Master.own[0].magicPoint
					+ 50 + Master.own[0].level * 5
					: 100 + Master.own[0].level * 10;
			Master.own[0].intimacy = Master.own[0].intimacy < 96 ? Master.own[0].intimacy + 4
					: 100;
			break;
		case 3:
			Master.own[0].healthPoint = Master.own[0].healthPoint < 20 + Master.own[0].level * 2 ? Master.own[0].healthPoint
					+ 80 + Master.own[0].level * 8
					: 100 + Master.own[0].level * 10;
			Master.own[0].magicPoint = Master.own[0].magicPoint < 20 + Master.own[0].level * 2 ? Master.own[0].magicPoint
					+ 80 + Master.own[0].level * 8
					: 100 + Master.own[0].level * 10;
			Master.own[0].intimacy = Master.own[0].intimacy < 94 ? Master.own[0].intimacy + 6
					: 100;
			break;
		default:
			Master.own[0].healthPoint = 100 + Master.own[0].level * 10;
			Master.own[0].magicPoint = 100 + Master.own[0].level * 10;
			Master.own[0].intimacy = Master.own[0].intimacy < 90 ? Master.own[0].intimacy + 10
					: 100;
		}
		p(Master.own[0].name + "生命值:" + Master.own[0].healthPoint + "，魔法值:"
				+ Master.own[0].magicPoint + "，与你的亲密度:"
				+ Master.own[0].intimacy);
		p("输入0返回:");
		IntIn(-1, 1);
		start();
	}

	void train() {// 训练
		p("请选择你的对手:\n1、皮卡丘(电)\n2、小火龙(火)\n3、妙蛙种子(草)\n4、杰尼龟(水)");
		int opponent = IntIn(0, 5);
		p("请选择对手等级:");
		int level = IntIn(0, 99999999);
		Pet pet;
		switch (opponent) {
		case 1:
			pet = new Pikachu("皮卡丘", level, 0);
			break;
		case 2:
			pet = new Charmander("小火龙", level, 0);
			break;
		case 3:
			pet = new Bulbasaur("妙蛙种子", level, 0);
			break;
		default:
			pet = new Squirtle("杰尼龟", level, 0);
		}
		new Fight(Master.own[0], pet).fight();
		start();
	}

	void challenge() { // 挑战
		p("你太弱了，还没到挑战黑暗四天王的时候，请继续努力训练!");
		p("输入0返回:");
		IntIn(-1, 1);
		start();
	}

	void show() {
		p(Master.own[0].name + " 等级:" + Master.own[0].level + " 生命值:"
				+ Master.own[0].healthPoint + " 魔法值:"
				+ Master.own[0].magicPoint + " 攻击力:" + Master.own[0].attack
				+ " 防御力:" + Master.own[0].defence + " 经验值:"
				+ Master.own[0].empiricalValue + " 亲密度:"
				+ Master.own[0].intimacy);

	}

	void load() {
		p("现未开发（配置文件，使用输入输出流）");
		p("输入0返回:");
		IntIn(-1, 1);
		homepage();
	}

	void set() {
		p("现未开发（配置文件，使用输入输出流）");
		p("输入0返回:");
		IntIn(-1, 1);
		homepage();
	}

	void exit() {
		p("再见!");
	}

}
