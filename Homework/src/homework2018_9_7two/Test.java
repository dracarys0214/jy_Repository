package homework2018_9_7two;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
	Scanner in = new Scanner(System.in);
	static Student[] stu = new Student[2]; // 为3是 nullpoint

	public Test() {
		stu[0] = new Student(1001, "李大", '男', 18, "高三一班");
		stu[1] = new Student(1002, "王二", '女', 17, "高二三班");
	}

	public static void main(String[] args) {
		// Integer a=new Integer(1);
		// Integer b=new Integer(1);
		// System.out.println(a==b);
		// String aa="abc";
		// aa=aa.concat("123");
		//
		// String a="abcde".charAt(4);
		// System.out.println(aa);
		Test t = new Test();
		if (t.login()) {
			t.homepage();
		}
	}

	void homepage() { // 主界面
		p("欢迎来到学生管理系统！");
		p("1、查看所有学生信息\n2、添加学生信息\n3、删除学生信息\n4、修改学生信息\n请选择:");
		switch (IntIn(0, 5)) {
		case 1:
			show();
			back();
			break;
		case 2:
			add();
			back();
			break;
		case 3:
			delete();
			back();
			break;
		default:
			change();
			back();
		}
	}

	boolean login() { // 登录
		for (int i = 0; i < 4; i++) {
			p("请输入用户名:");
			String user = in.next();
			p("请输入密码:");
			String pwd = in.next();
			if (user.equals("admin") && pwd.equals("m123")) {
				p("登录成功！");
				return true;
			}
			p("用户名或密码错误，请重新输入:");
			p("剩余" + (3 - i) + "次");
		}
		p("该账户已被锁定!");
		return false;
	}

	void show() { // 1、查看所有学生信息
		for (Student t : stu) {
			if (t != null && t.getName() != null) { // t==null,则t.getName()等会空指针异常
				p("编号:" + t.getId() + "\t姓名:" + t.getName() + "\t性别:"
						+ t.getSex() + "\t年龄:" + t.getAge() + "\t年级:"
						+ t.getGrade());
			}
		}
		// for (int i = 0; i < stu.length; i++) {
		// p((i + 1) + "\t编号:" + stu[i].getId() + "\t姓名:" + stu[i].getName()
		// + "\t性别:" + stu[i].getSex() + "\t年龄:" + stu[i].getAge()
		// + "\t年级:" + stu[i].getGrade());
		// }
		System.out.println("stu数组长度" + stu.length);
	}

	void add() {
		for (int i = 0; i < stu.length; i++) {
			if (stu[i].getName() == null) {
				p("请输入编号:");
				stu[i].setId(in.nextInt());
				p("请输入姓名:");
				stu[i].setName(in.next());
				p("请输入性别:");
				stu[i].setSex(in.next().charAt(0));
				p("请输入年龄:");
				stu[i].setAge(in.nextInt());
				p("请输入年级:");
				stu[i].setGrade(in.next());
				p("增添成功!");
				break;
			}
			if (i == stu.length - 1) {
				stu = Arrays.copyOf(stu, i + 2); // 数组长度+1
				stu[i + 1] = new Student();// 不new则空指针异常
			}
		}
	}

	void delete() { // 3、删除学生信息
		show();
		p("请输入需要删除的学生编号：");
		int id = in.nextInt();
		for (int i = 0; i < stu.length; i++) { // 遍历
												// &&否则stu[stu.lenth]
			// 当stu[i]为null，后面皆为null
			if (id == stu[i].getId()) {
				int j = i;
				for (; j < stu.length - 1; j++) { // -2
					stu[j].setId(stu[j + 1].getId());// 否则
														// java.lang.NullPointerException
					stu[j].setName(stu[j + 1].getName());
					stu[j].setSex(stu[j + 1].getSex());
					stu[j].setAge(stu[j + 1].getAge());
					stu[j].setGrade(stu[j + 1].getGrade());
				}
				stu[j].setId(0);
				stu[j].setName(null);
				stu[j].setSex('\0');
				stu[j].setAge(0);
				stu[j].setGrade(null);
				p("删除成功!");
				return;
			}
		}
		p("未查到此编号!");
	}

	void change() {// 4、修改学生信息
		show();
		p("请输入需要修改的学生编号：");
		int id = in.nextInt();
		for (int i = 0; i < stu.length; i++) { // 遍历
												// &&
			// 当stu[i]为null，后面皆为null
			if (id == stu[i].getId()) {
				p("请输入编号:");
				stu[i].setId(in.nextInt());
				p("请输入姓名:");
				stu[i].setName(in.next());
				p("请输入性别:");
				stu[i].setSex(in.next().charAt(0));
				p("请输入年龄:");
				stu[i].setAge(in.nextInt());
				p("请输入年级:");
				stu[i].setGrade(in.next());
				p("修改成功!");
				return;
			}
		}
		p("未查到此编号!");
	}

	void back() { // 返回主页面
		p("输入0返回:");
		IntIn(-1, 1);
		homepage();
	}

	void p(String str) { // 简化输出
		System.out.println(str);
	}

	int IntIn(int i, int j) { // 输入整数限制
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
