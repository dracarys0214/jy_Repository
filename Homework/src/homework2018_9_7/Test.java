package homework2018_9_7;

public class Test {
	public static void main(String[] args) {
		new Test().show().print();
	}

	Goods show() {
		Goods g = null;
		P.p("1��������\n2��ʳƷ��\n��ѡ��:");
		switch (P.IntIn(0, 3)) {
		case 1:
			g = new TVs();
			break;
		default:
			g = new Foods();
		}
		return g;
	}
}
