package main.service;

import java.sql.SQLException;

import main.dao.UserDao;
import main.domain.User;


public class UserService {
	//用户登录的方法
	public User login(String username, String password) throws SQLException {
		UserDao dao = new UserDao();
		return dao.login(username,password);
	}
}
