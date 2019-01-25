package reflect.module;

import reflect.Bean;


@Bean("user")
public class User {
	private String name="aa";
	private int id=11;

	public User() {
		super();
	}

	public User(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
}
