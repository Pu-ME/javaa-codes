package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;
import exception.UserException;
import util.SendJMail;

public class UserService {
	UserDao ud = new UserDao();
	public void regist(User user) throws UserException {
		try {
			ud.addUser(user);
			String emailMsg = "注册成功，请<a href='http://www.product.com/activeServlet?activeCode="+user.getActiveCode()+"'>激活</a>后登录";
			SendJMail.sendMail(user.getEmail(), emailMsg);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("注册失败！");
		}
	}
	public void activeUser(String activeCode) throws UserException {
		
		try {
			User user = ud.findUserByActiveCode(activeCode);
			if(user!=null){
				ud.activeCode(activeCode);
				return ;
			}
			throw new UserException("激活失败！");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("激活失败！");
		}
	}
	public User login(String username, String password) throws UserException {
		User user = null;
		try {
			user = ud.findUserByUserNameAndPassword(username, password);
			if(user==null){
				throw new UserException("用户名或密码错误！");
			}
			if(user.getState()==0){
				throw new UserException("用户未激活！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserException("用户名或密码错误！");
		}
		return user;
	}
	
}
