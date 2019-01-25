package thread02;

import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable {
	static List<Integer> s = new ArrayList<>();
	int m = 1;

	@Override
	synchronized public void run() {

		String name = Thread.currentThread().getName();
		System.out.println(name + (name.equals("运动员一") ? "起跑" : "接力"));
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " \t跑了" + (m++) + "米");
		}
		if (name.equals("运动员四")) {
			System.out.println(name + "到达终点");
		}
	}

}
