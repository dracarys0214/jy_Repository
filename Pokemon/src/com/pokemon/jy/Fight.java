package com.pokemon.jy;
/**
 * ս������
 * @author jy 2018��9��6������3:21:30
 *
 */
public class Fight extends Util {
	Pet p1, p2;
	int temp1, temp2;

	public Fight(Pet p1, Pet p2) {// p1�ҷ���p2�з�
		super();
		this.p1 = p1;
		this.p2 = p2;
		temp1 = p1.attack; // ��ʱ���p1 p2������
		temp2 = p2.attack;
	}

	void fight() { // �ҷ��ȹ�
		jugde();
		do {
			fight1();
			if (p2.healthPoint <= 0) {
				p2.healthPoint = 0;
				p1.empiricalValue += (p2.empiricalValue / 3); // ��ö��ֵ�3��֮һ����ֵ
				p1.intimacy += 2;// ���ܶ�+2
				p(p1.name + "ʤ����!����+" + p2.empiricalValue / 3 + "�㣬���ܶ�+2��");
				if (p1.empiricalValue >= (p1.level + 1) * (p1.level + 1) * 100) {// ���p1����ֵ������һ�ȼ��ģ�������
					p(p1.name + "������!");
					int level = p1.level + 1;
					int intimacy = p1.intimacy;
					String name = p1.name;
					if (Master.own[0].name.contains("Ƥ����")) {
						Master.own[0] = new Pikachu(name, level, intimacy); // �½�һ���µ�level+1�ĳ���
					} else if (Master.own[0].name.contains("С����")) {
						Master.own[0] = new Pikachu(name, level, intimacy);
					} else if (Master.own[0].name.contains("��������")) {
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
				p("������!���ܶ�-1��");
				break;
			}
		} while (true);
		p1.attack = temp1;// ���ع�����
		p2.attack = temp2;

	}

	void fight1() { // p1����
		int r1 = p1.attack > p2.defence ? p1.attack // �Է��������
				- p2.defence : 0;
		p2.healthPoint -= r1;
		p(p1.name + "�����˹�����" + p2.name + "�ܵ���" + r1 + "���˺�!");
		pause(1000);// ͣ1s
	}

	void fight2() { // p2����
		int r1 = p2.attack > p1.defence ? p2.attack // �Է��������
				- p1.defence : 0;
		p1.healthPoint -= r1;
		p(p2.name + "�����˹�����" + p1.name + "�ܵ���" + r1 + "���˺�!");
		pause(1000);// ͣ1s
	}

	void jugde() { // �������
		if (p1.property == Property.ELECTRICITY) { // ��
			if (p2.property == Property.ELECTRICITY) { // �� vs ��,p1 1/2����p2 1/2��
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // �� vs ˮ,p1������
				p1.attack *= 2;
			}
			if (p2.property == Property.GRASS) { // �� vs ��,p1 1/2��
				p1.attack /= 2;
			}
		}

		if (p1.property == Property.FIRE) {// ��
			if (p2.property == Property.ELECTRICITY) { // �� vs ��,p1 1/2����p2 1/2��
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // �� vs ˮ,p1 1/2�� ,p2������
				p1.attack /= 2;
				p2.attack *= 2;
			}
			if (p2.property == Property.GRASS) { // �� vs ��,p1 ������,p2 1/2��
				p1.attack *= 2;
				p2.attack /= 2;
			}
		}

		if (p1.property == Property.GRASS) {// ��
			if (p2.property == Property.GRASS) { // �� vs ��,p1 1/2����p2 1/2��
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.WATER) { // �� vs ˮ,p1 ������ ,1/2��
				p1.attack *= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.FIRE) { // �� vs ��,p1 1/2��,p2 ������
				p1.attack /= 2;
				p2.attack *= 2;
			}
		}

		if (p1.property == Property.WATER) {// ˮ
			if (p2.property == Property.WATER) { // ˮ vs ˮ,p1 1/2����p2 1/2��
				p1.attack /= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.FIRE) { // ˮ vs ��,p1 ������ ,1/2��
				p1.attack *= 2;
				p2.attack /= 2;
			}
			if (p2.property == Property.GRASS) { // ˮ vs ��,p1 1/2��,p2 ������
				p1.attack /= 2;
				p2.attack *= 2;
			}
			if (p2.property == Property.ELECTRICITY) { // ˮ vs ��, p2 ������
				p2.attack *= 2;
			}
		}

	}

}
