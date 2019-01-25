package homework2018_9_7;

public class Test {
	public static void main(String[] args) {
		new Test().show().print();
	}

	Goods show() {
		Goods g = null;
		P.p("1、电视类\n2、食品类\n请选择:");
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
