package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.UserException;
import service.UserService;

public class ActiveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String activeCode = request.getParameter("activeCode");
		
		UserService us = new UserService();
		try {
			us.activeUser(activeCode);
			request.getRequestDispatcher("/activesuccess.jsp").forward(request, response);
		} catch (UserException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
