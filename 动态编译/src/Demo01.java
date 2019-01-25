
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 测试java的动态编译
 */
public class Demo01 {
	public static void main(String[] args) {

		// 通过IO流操作，将字符串存储成一个临时文件(.java)，然后调用动态编译方法！
		Scanner in = new Scanner(System.in);
		System.out.println("请输入打印信息：");
		String msg = in.nextLine();
		System.out.println("请输入类名：");
		String className = in.next();
		// \" 转义
		String str = "public class "
				+ className
				+ " {public static void main(String[] args){System.out.println(\""
				+ msg + "\");}}";
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("d:/myjava/" + className + ".java")));
			bw.write(str);
			bw.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		in.close();

		
		// 通过JavaCompiler编译类
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int result = compiler.run(null, null, null, "d:/myjava/" + className + ".java");
		System.out.println(result == 0 ? "编译成功" : "编译失败");

		
		// 通过Runtime加载类
//		Runtime run = Runtime.getRuntime();
//		Process process = null;
//		try {
//			process = run.exec("java -cp  d:/myjava " + className);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		InputStream is = process.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//		String info = "";
//		try {
//			while ((info = reader.readLine()) != null) {
//				System.out.println(info);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		//通过反射加载类
		 try {
		 URL[] urls = new URL[] { new URL("file:/" + "d:/myjava/") };
		 URLClassLoader loader = new URLClassLoader(urls);
		 Class c = loader.loadClass(className);
		 // 调用加载类的main方法
		 Method m = c.getMethod("main", String[].class);
		 m.invoke(null, (Object) new String[] {});
		 // 由于可变参数是JDK5.0之后才有。
		 // m.invoke(null, (Object)new
		 // String[]{});会编译成:m.invoke(null,"aa","bb"),就发生了参数个数不匹配的问题。
		 // 因此，必须要加上(Object)转型，避免这个问题。
		 // public static void main(String[] args)
		
		 } catch (Exception e) {
		 e.printStackTrace();
		 }

	}
}
