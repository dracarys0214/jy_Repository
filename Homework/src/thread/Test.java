package thread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread m = new MyThread();
		Thread t1 = new Thread(m, "线程一");
		Thread t2 = new Thread(m, "线程二");
		long time1=System.nanoTime();
		t1.start();
		long time2=System.nanoTime();
		System.out.println(time2-time1);
		t2.start();
		long time3=System.nanoTime();
		System.out.println(time3-time1);

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("容器元素个数:"+MyThread.s.size());
		System.out.println(MyThread.s.toString());
	}

}
