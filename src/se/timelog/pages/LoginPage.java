package se.timelog.pages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import se.kyh.ad10.timeloggers.server.entities.User;
import se.timelog.rmi.RMIServerComm;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends JspPage {
	
	@Override
	public void realDoStuff(List<String> remainingPath, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		} else {
			String email, password;
			
			email = request.getParameter("email");
			password = request.getParameter("password");
			
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			
			boolean status = login(user);
			if (status) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", email);
				response.sendRedirect("/Timelog/project/create");
			} else {
				request.setAttribute("failed", "Email or password does not match");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
			}
		}
		
	}
	
	public boolean doAuthorize(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		return true;
	}
	
	public boolean login(User user){
		String email = user.getEmail();
		String password = user.getPassword();
		
		UUID sessionId = null;
		try {
			sessionId = RMIServerComm.get().getSessionId();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User answer = null;
		try {
			answer = RMIServerComm.get().getPublicInterface(sessionId).getUserDAO().login(email, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(answer == null){
			return false;
		}
		return true;
	}
}
