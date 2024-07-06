package com.crud.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.pojo.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");			
			
		}catch(Exception ex) {
			System.err.println( ex);
			
		}
		return con;
		
	}

	@Override
	public int save(Employee e) {
		int status=0;
		try {
			Connection con = EmployeeDaoImpl.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into user905(name,password,email,country)"
					+ " values(?,?,?,?)");	
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
			
		}
		
		return status;
	}

	@Override
	public int update(Employee e) {
		int status=0;
		try {
			Connection con = EmployeeDaoImpl.getConnection();
			PreparedStatement ps = 
					con.prepareStatement("update user905 set name=?,password=?,email=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPass());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception ex) {
			System.out.println(ex);
			
		}
		return status;
	}

	@Override
	public int delete(int id) {
		int status=0;
		try {
			Connection con = EmployeeDaoImpl.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user905 where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
			
		}catch(Exception ex) {
			
		}
		return status;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = new Employee();
		
		try {
			Connection con = EmployeeDaoImpl.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905 where id=?");
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			if(rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPass(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				con.close();
				
			}
		}catch(Exception ex) {
			System.out.println(ex);
			
		}
		return e;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>list = new ArrayList<>();
		
		try {
			Connection con = EmployeeDaoImpl.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user905");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setPass(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setCountry(rs.getString(5));
				list.add(emp);
				
				con.close();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return list;
	}

}
