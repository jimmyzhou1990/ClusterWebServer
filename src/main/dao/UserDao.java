package main.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import main.domain.User;
import main.utils.DataSourceUtils;

public class UserDao {  
	
	//用户登录的方法
	public User login(String username, String password) throws SQLException {
		//QueryRunner是DBUtils的核心类
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		
		User user = null;
		
		user = runner.query(sql, new BeanHandler<User>(User.class), username,password);
		
		if(user != null)
		{
			System.out.println(user.getUsername());
			System.out.println(user.getPassword());
		}
		else
		{
			System.out.println("cannot find "+username);
		}
		return  user;
	}
}
