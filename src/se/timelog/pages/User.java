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
 * Servlet implementation class User
 */
public class User extends Page {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/views/user_create.jsp").forward(request, response);
		} else {
			String firstname, lastname, email, password;
			
			firstname = request.getParameter("firstname");
			lastname = request.getParameter("lastname");
			email = request.getParameter("email");
			password = request.getParameter("password");
			
			UserModel usermodel = new UserModel();
			usermodel.setFirstName(firstname);
			usermodel.setLastName(lastname);
			usermodel.setEmail(email);
			usermodel.setPassword(password);
			
			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorlist  = mockupRMI.userCreate(usermodel);
			if (errorlist.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);	
			} else {
				request.getRequestDispatcher("/WEB-INF/views/user_create.jsp").forward(request, response);	
			}
		}
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
		
	}

}
