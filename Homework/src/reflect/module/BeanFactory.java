package reflect.module;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import reflect.Bean;

@Bean("beanFactory")
public class BeanFactory {
	List<String> list = new ArrayList<String>();
	HashMap<String, Object> map = new HashMap<>();

	// 获取所有文件名
	public void getFileName(File file) {
		if (file.isFile()) {
			list.add(file.getAbsolutePath());
			System.out.println("包下文件绝对路径:" + file.getAbsolutePath());
			return;
		}

		if (file.listFiles() != null) {
			for (File f : file.listFiles()) {
				getFileName(f);
			}
		}
	}

	// 获取所有类名
	public void getClassNames(String packageName) {

		String path = this.getClass().getClassLoader().getResource("")
				.getPath();// 获取包路径()末尾带“/”
		//String path = BeanFactory.class.getResource("").getPath();
		System.out.println("包路径:" + path + packageName);
		getFileName(new File(path + packageName));

		for (int i = 0; i < list.size(); i++) {
			String name = list.get(i).replace("\\", ".");

			name = name.substring(name.indexOf(packageName),
					name.lastIndexOf("."));
			System.out.println("类名:" + name);
			list.set(i, name);
		}
		getInstance();

	}

	// 获取实例
	public void getInstance() {
		System.out.println("##########");
		for (String t : list) {
			try {
				System.out.println("类名:" + t);
				Class<?> clazz = Class.forName(t);// 创建Class类
				Bean bean = clazz.getAnnotation(Bean.class);// 通过clazz对象获取类的注解
				if (bean != null) { // 有bean注解
					Object obj = null;// 创建对象
					if (t.endsWith("Bean")) { // 无实例，例如注解 接口 抽象类
						map.put(bean.value(), obj);
						continue;
					}
					obj = clazz.newInstance();// 创建实例
					Field[] fields = clazz.getDeclaredFields();// 通过反射获取属性
					if (fields == null) {// 无属性
						map.put(bean.value(), obj);
						continue;
					}
					for (Field f : fields) {
						System.out.println("-属性:" + f);
					}

					for (Field f : fields) { // 通过Set方法改变属性的值
						String methodName = "set" + UpperFirst(f.getName());
						System.out.println(methodName);
						try {// 如果没有此方法
							Method m = clazz.getDeclaredMethod(methodName,
									f.getType());
							System.out.println("---方法:" + m);

							// 这里只有一个User有set get方法
							m.invoke(obj, f.getType().newInstance());
							System.out.println("---set方法执行后name=null:"
									+ f.getType().newInstance());
						} catch (Exception e) {
							System.out.println("---无此方法:" + methodName);
							if (f.getType()==int.class) {//id getType().newInstance()异常
								System.out.println("---int.class.newInstance()会出异常！");
							}
						}
					}

					map.put(bean.value(), obj);
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}

	// 字符串首字母大写
	public String UpperFirst(String str) {
		return (char) (str.charAt(0) - 32) + str.substring(1);
	}

	@Override
	public String toString() {
		return "BeanFactory [list=" + list + ", map=" + map + "]";
	}

}
