package file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class AllFileName {

	public static void main(String[] args) throws IOException {
		File a = new File("d:/Ѹ������");
		printAll(a, 0);
	}

	static void printAll(File f, int level) {
		// if (level > 0) {
		// System.out.print("��" + level + "��");// ��һ���� Ѹ�����ش�ӡ��0���ڶ�����sp88083�Լ����
		// }
		// for (int i = 0; i < level; i++) {
		// System.out.print("---");
		// }
		if (f.isFile()) {
			System.out.println(f.getName());
		}
		if (f.isDirectory()) {
			for (File t : f.listFiles(new FileFilter() { // �����ڲ���
						@Override
						public boolean accept(File pathname) {// ��дaccept������false��listFile���鲻��Ӹ��ļ�
							if (pathname.isDirectory()) {
								return true;
							}
							if (pathname.getName().endsWith(".mkv")) {// �� .mkv �������ַ���
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
