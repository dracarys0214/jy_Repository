package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) {
		String src = "D:/旧台式信息/D盘/图片";
		String des = "D:/旧台式信息/桌面";
		new Copy().copyDirectory(src, des);
	}

	void copyDirectory(String src, String des) {
		File f1 = new File(src);
		File f2 = new File(des + "/" + f1.getName());
		// if (new File(des).isFile()) {
		// try {
		// throw new Exception();
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// System.out.println("destination不是文件夹！");
		// System.exit(1);
		// }
		// }

		if (!f1.exists()) {// 如果f1(第一个文件夹)不存在
			System.out.println("文件夹不存在！");
			System.exit(0);
		}
		System.out.println(f2.getPath());// 打印文件名

		if (f1.isFile()) { // 是文件 则复制
			copyFile(src, f2.getPath());
		} else {
			f2.mkdir();// 创建文件夹
			if (f1.list() != null) {// f1不能为空文件夹，否则f1.list()==null;copyFile(src, f2.getPath()) NullpointerException
				for (String t : f1.list()) {
					copyDirectory(src + "/" + t, f2.getPath());
				}
			}
		}
	}

	void copyFile(String src, String des) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(des);
			byte[] flush = new byte[1024];
			while (fis.read(flush) != -1) {
				fos.write(flush);
			}
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
