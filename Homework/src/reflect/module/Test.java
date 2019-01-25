package reflect.module;

import java.util.Set;

import reflect.Bean;

@Bean("test")
public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//System.out.println(int.class.newInstance()); //基本类型无 Class newInstance()方法
		BeanFactory bf = new BeanFactory();
		bf.getClassNames("reflect");
		System.out.print("Map:");//HashMap重写了ToString()
		System.out.println(bf.map);
		Set<String> set=bf.map.keySet();
		for(String t:set){
			System.out.println("注解:"+t+"\t实例:"+bf.map.get(t));
		}
	}

}
