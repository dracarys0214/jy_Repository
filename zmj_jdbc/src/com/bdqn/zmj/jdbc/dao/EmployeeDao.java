package com.bdqn.zmj.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bdqn.zmj.jdbc.entity.Dept;
import com.bdqn.zmj.jdbc.entity.Employee;

//data access object
public class EmployeeDao {
	private Connection conn;
	private PreparedStatement ppst;
	private ResultSet rs;

	// 连接数据库(参数：1、数据库名，2、用户名，3、密码)
	public Connection getConn() throws SQLException {
		String database = "company";
		String user = "root";
		String pwd = "jy0214";
		try {
			// 通过反射加载数据库驱动Driver
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/" + database;
			conn = DriverManager.getConnection(url, user, pwd);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	// 查询(参数：)
	public List<Employee> getList(Employee e) {
		// 获取数据
		String eid = e.getEid();
		String ename = e.getEname();
		String age = e.getAge();
		String did = e.getDept().getDid();

		// 存储数据集合
		List<String> args = new ArrayList<>();

		// Employee数据
		List<Employee> list = new ArrayList<>();

		StringBuffer sql = new StringBuffer(
				"select e.emp_id,e.emp_name,e.age,d.dept_id,d.dept_name"
						+ " from employee e left join dept d on e.dept_id=d.dept_id where 1=1 ");
		if (eid != null) {
			sql.append(" and e.emp_id=?");
			args.add(eid);
		}
		if (ename != null) {
			sql.append(" and e.emp_name=?");
			args.add(ename);
		}
		if (age != null) {
			sql.append(" and e.age=?");
			args.add(age);
		}
		if (did != null) {
			sql.append(" and d.dept_id=?");
			args.add(did);
		}

		try {
			// 执行sql语句
			ppst = getConn().prepareStatement(sql.toString());

			if (args != null && !"".equals(args)) {
				// 问号循环赋值
				for (int i = 0; i < args.size(); i++) {
					ppst.setObject(i + 1, args.get(i));
				}
				// 获取数据并封装到Employee对象里,将对象们添加到List里
				rs=ppst.executeQuery();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEid(rs.getString("emp_id"));
					emp.setEname(rs.getString("emp_name"));
					emp.setAge(rs.getString("age"));
					emp.setDept(new Dept(rs.getString("dept_id"), rs
							.getString("dept_name")));
					list.add(emp);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return list;
	}

	public boolean add(Employee e) {
		String sql = "insert into employee values(?,?,?,?)";
		try {
			ppst = getConn().prepareStatement(sql);
			ppst.setObject(1, e.getEid());
			ppst.setObject(2, e.getEname());
			ppst.setObject(3, e.getAge());
			ppst.setObject(4, e.getDept().getDid());
			ppst.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean del(String eid){
		try {
			ppst=getConn().prepareStatement("delete from employee where emp_id=?");
			ppst.setObject(1, eid);
			ppst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public int executeUpdate(String sql,Object...obj){//可变参数（Object:参数类型不定）
		try {
			ppst=getConn().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ppst.setObject(i + 1, obj[i]);
			}
			return ppst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;	
		}finally{
			close();
		}		
		
	}
	
	
	
	private void close(){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(ppst!=null){
				try {
					ppst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(conn!=null){
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
