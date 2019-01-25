package com.pokemon.jy;
/**
 * ����ʼ������
 * @author jy 2018��9��6������3:19:57
 *
 */
public class Main extends Util {
	public static void main(String[] args) {
		new Main().homepage();
	}

	void homepage() {
		p("��ѡ��:\n1����ʼ��Ϸ\n2���������\n3��ϵͳ����\n4���˳���Ϸ");
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
		p("��ѡ��:\n1����������\n2��ιʳ\n3��ѵ��\n4����ս������\n5����ʾ������Ϣ");
		switch (IntIn(0, 6)) {
		case 1:
			if (Master.own[0] != null) {
				p("������������޷��ظ���ȡ!");
				start();
			}
			adopt();
			break;
		case 2:
			if (Master.own[0] == null) {
				p("������������!");
				start();
			}
			feed();
			break;
		case 3:
			if (Master.own[0] == null) {
				p("������������!");
				start();
			}
			train();
			break;
		case 4:
			if (Master.own[0] == null) {
				p("������������!");
				start();
			}
			challenge();
			break;
		default:
			if (Master.own[0] == null) {
				p("��δӵ�г��������������!");
				start();
			}
			show();
			p("����0����:");
			IntIn(-1, 1);
			start();
		}
	}

	void adopt() {// ��������
		p("С����ã����Ǵ�ľ��ʿ��");
		pause(1000);
		p("��ѡ����ĳ���:\n1��Ƥ����(��)\n2��С����(��)\n3����������(��)\n4�������(ˮ)\n5����ȫ��Ҫ(�ٺ�!)");
		Pet pet = null;
		switch (IntIn(0, 6)) {
		case 1:

			pet = new Pikachu("", 1, 0);
			p("�������������:");
			pet.name = "Ƥ����-" + in.next();

			break;
		case 2:
			pet = new Charmander("", 1, 0);
			p("�������������:");
			pet.name = "С����-" + in.next();

			break;
		case 3:
			pet = new Bulbasaur("", 1, 0);
			p("�������������:");
			pet.name = "��������-" + in.next();
			break;
		case 4:
			pet = new Squirtle("", 1, 0);
			p("�������������:");
			pet.name = "�����-" + in.next();
			break;
		default:
			p("��ľ��ʿ������һ���ƣ���!");
			start();
		}
		Master.own[0] = pet;
		p("Ϊ����ֹ�ڰ���������ά�������ƽ�������" + pet.name + "̤���µ���;��!");
		p("����0����:");
		IntIn(-1, 1);
		start();
	}

	void feed() {// ιʳ

		p("��ѡ��ʳ��:\n1���ǹ�(����ֵ+20%��ħ��ֵ+20%)\n2������(����ֵ+50%��ħ��ֵ+50%)\n3������(����ֵ+80%��ħ��ֵ+80%)\n4���ɶ�(����ֵ+100%��ħ��ֵ+100%)");
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
		p(Master.own[0].name + "����ֵ:" + Master.own[0].healthPoint + "��ħ��ֵ:"
				+ Master.own[0].magicPoint + "����������ܶ�:"
				+ Master.own[0].intimacy);
		p("����0����:");
		IntIn(-1, 1);
		start();
	}

	void train() {// ѵ��
		p("��ѡ����Ķ���:\n1��Ƥ����(��)\n2��С����(��)\n3����������(��)\n4�������(ˮ)");
		int opponent = IntIn(0, 5);
		p("��ѡ����ֵȼ�:");
		int level = IntIn(0, 99999999);
		Pet pet;
		switch (opponent) {
		case 1:
			pet = new Pikachu("Ƥ����", level, 0);
			break;
		case 2:
			pet = new Charmander("С����", level, 0);
			break;
		case 3:
			pet = new Bulbasaur("��������", level, 0);
			break;
		default:
			pet = new Squirtle("�����", level, 0);
		}
		new Fight(Master.own[0], pet).fight();
		start();
	}

	void challenge() { // ��ս
		p("��̫���ˣ���û����ս�ڰ���������ʱ�������Ŭ��ѵ��!");
		p("����0����:");
		IntIn(-1, 1);
		start();
	}

	void show() {
		p(Master.own[0].name + " �ȼ�:" + Master.own[0].level + " ����ֵ:"
				+ Master.own[0].healthPoint + " ħ��ֵ:"
				+ Master.own[0].magicPoint + " ������:" + Master.own[0].attack
				+ " ������:" + Master.own[0].defence + " ����ֵ:"
				+ Master.own[0].empiricalValue + " ���ܶ�:"
				+ Master.own[0].intimacy);

	}

	void load() {
		p("��δ�����������ļ���ʹ�������������");
		p("����0����:");
		IntIn(-1, 1);
		homepage();
	}

	void set() {
		p("��δ�����������ļ���ʹ�������������");
		p("����0����:");
		IntIn(-1, 1);
		homepage();
	}

	void exit() {
		p("�ټ�!");
	}

}
