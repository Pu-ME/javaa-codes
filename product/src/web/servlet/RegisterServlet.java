package web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.User;
import exception.UserException;
import service.UserService;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String ckcode = request.getParameter("ckcode");
			String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
			if(!checkcode_session.equals(ckcode)){
				request.setAttribute("ckcode_msg", "验证码错误！");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			}
			User user = new User(); 
			try {
				BeanUtils.populate(user, request.getParameterMap());
				user.setActiveCode(UUID.randomUUID().toString());
				UserService us = new UserService();
				us.regist(user);
				request.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
			}catch(UserException e){
				request.setAttribute("user_msg", e.getMessage());
				request.getRequestDispatcher("/register.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
