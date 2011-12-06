package se.timelog.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.timelog.UserModel;
import se.timelog.rmi.MockupRMI;

/**
 * Servlet implementation class Login
 */
public class Login extends JspPage {
	
	@Override
	public void doStuff(List<String> remainingPath, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "login");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String username, password;
			
			username = request.getParameter("username");
			password = request.getParameter("password");
			
			UserModel usermodel = new UserModel();
			usermodel.setEmail(username);
			usermodel.setPassword(password);
			
			MockupRMI mockupRMI = new MockupRMI();
			boolean status  = mockupRMI.login(usermodel);
			if (status) {
				request.setAttribute("content", "home");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("content", "home");
				request.setAttribute("failed", "Fel användarnamn eller lösenord");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			}
		}
		
	}

}
