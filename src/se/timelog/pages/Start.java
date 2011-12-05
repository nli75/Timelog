package se.timelog.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.timelog.UserModel;
import se.timelog.pages.Page;
import se.timelog.rmi.MockupRMI;

/**
 * Servlet implementation class Login
 */
public class Start extends RestPage {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
	}

	@Override
	public void doUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		} else {
			String  username, password;
			
			username = request.getParameter("username");
			password = request.getParameter("password");
			
			UserModel usermodel = new UserModel();
			usermodel.setEmail(username);
			usermodel.setPassword(password);
			
			MockupRMI mockupRMI = new MockupRMI();
			boolean status  = mockupRMI.login(usermodel);
			if (status) {
				request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);	
			} else {
				request.setAttribute("failed", "Fel användarnamn eller lösenord");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
			}
		}
		
	}

}
