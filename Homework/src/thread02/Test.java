package thread02;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		MyThread m = new MyThread();
		Thread t1 = new Thread(m, "运动员一");
		Thread t2 = new Thread(m, "运动员二");
		Thread t3 = new Thread(m, "运动员三");
		Thread t4 = new Thread(m, "运动员四");
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
	}

}
