package file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class AllFileName {

	public static void main(String[] args) throws IOException {
		File a = new File("d:/迅雷下载");
		printAll(a, 0);
	}

	static void printAll(File f, int level) {
		// if (level > 0) {
		// System.out.print("第" + level + "层");// 第一次是 迅雷下载打印的0，第二次是sp88083自己打的
		// }
		// for (int i = 0; i < level; i++) {
		// System.out.print("---");
		// }
		if (f.isFile()) {
			System.out.println(f.getName());
		}
		if (f.isDirectory()) {
			for (File t : f.listFiles(new FileFilter() { // 匿名内部类
						@Override
						public boolean accept(File pathname) {// 重写accept方法，false则listFile数组不添加该文件
							if (pathname.isDirectory()) {
								return true;
							}
							if (pathname.getName().endsWith(".mkv")) {// 以 .mkv 结束的字符串
								return true;
							}
							return false;
						}

					})) {
				printAll(t, level + 1);
			}
		}
	}

}
