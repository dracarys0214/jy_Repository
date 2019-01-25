package reflection;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	int id;
	int age;
	String name;
	Date birthday;

	public User() {
		super();
	}

	public User(int id, int age, String name, Date birthday) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name
				+ ", birthday=" + birthday + "]";
	}




	
}
