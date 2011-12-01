package se.timelog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class User extends HttpServlet{
	/**
	 * Denna class instansieras av UrlHandler
	 * om Url är timelog/User/*
	 * skall ladda rätt jsp
	 */
	private static final long serialVersionUID = 1L;

	//request = metodnamn
	
	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.setAttribute("namn", "Tobias N");		
			
			request.getRequestDispatcher("/WEB-INF/views/admin_create_user.jsp").forward(request, response);
		
	}	

}
