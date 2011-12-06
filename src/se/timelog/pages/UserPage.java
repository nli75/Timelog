package se.timelog.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.User;
import se.timelog.pages.RestPage;
import se.timelog.rmi.MockupRMI;

/**
 * Servlet implementation class UserPage
 */
public class UserPage extends RestPage {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "user_create");

			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String firstName, lastName, email, password;
			
			firstName = request.getParameter("firstName");
			lastName = request.getParameter("lastName");
			email = request.getParameter("email");
			password = request.getParameter("password");
			
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setPassword(password);
			
			MockupRMI mockupRMI = new MockupRMI();

			ArrayList<String> errorlist  = mockupRMI.userCreate(usermodel);
			if (errorlist.isEmpty()) {
				request.setAttribute("content", "success");

				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("errors", errorlist);
				request.setAttribute("content", "success");

				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	

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
