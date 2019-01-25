package thread;

import java.util.ArrayList;
import java.util.List;

public class MyThread implements Runnable {
	static List<Integer> s = new ArrayList<>();
	int m = 1;

	@Override
		public void run() {
		for (int i = 0; i < 500; i++) {
			synchronized (s) {
				System.out.println(Thread.currentThread().getName() + " m值："
						+ m);
				s.add(m++);

			}
		}
	}

}
