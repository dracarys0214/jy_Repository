package Computer;

import java.util.Scanner;

public class Test {
	static Scanner in = new Scanner(System.in);

	static void cpu(CPU c) {
		System.out.println("CPU\t品牌:" + c.brand() + "\t主频:" + c.frequency());
	}

	static void ems(EMS e) {
		System.out.println("EMS\t型号:" + e.type() + "\t容量:" + e.capacity());
	}

	static void harddisk(HardDisk h) {
		p("HardDisk\t\t容量:" + h.capacity());
	}

	public static void main(String[] args) {
		CPU c = null;
		EMS e = null;
		HardDisk h = null;
		p("请选择CPU:1、intel\t2、amd");
		if (IntIn(0, 3) == 1) {
			c = new CPU_Intel();
		} else {
			c = new CPU_AMD();
		}

		p("请选择EMS:1、Sumsung\t2、Kingston");
		if (IntIn(0, 3) == 1) {
			e = new EMS_Sumsung();
		} else {
			e = new EMS_Kingston();
		}

		p("请选择HardDisk:1、Seagate\t2、WD");
		if (IntIn(0, 3) == 1) {
			h = new HardDisk_Seagate();
		} else {
			h = new HardDisk_WD();
		}

		cpu(c);
		ems(e);
		harddisk(h);
	}

	static void p(String str) { // 简化输出
		System.out.println(str);
	}

	static int IntIn(int i, int j) { // 输入整数限制
		int m;
		while (true) {
			if (in.hasNextInt()) {
				m = in.nextInt();
				if (m > i && m < j) {
					break;
				}
				p(m + " 输入错误，请重新输入!");
			} else {
				p(in.next() + " 输入错误，请重新输入!");
			}
		}
		return m;
	}
}
