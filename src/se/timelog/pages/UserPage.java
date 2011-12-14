package se.timelog.pages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.User;
import se.timelog.pages.RestPage;
import se.timelog.rmi.RMIServerComm;

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
			
			ArrayList<String> errorList  = userCreate(user);
			if (errorList.isEmpty()) {
				request.setAttribute("content", "success");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("errorList", errorList);
				request.setAttribute("content", "user_create");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
			}
		}
	}

	//create user start
	public ArrayList<String> userCreate(User user) {
		
		ArrayList<String> errorList = new ArrayList<String>();

		// E-mail
		if (user.getEmail().length() == 0) {
			errorList.add("E-mail not set.");
		} else {
			if (user.getEmail().length() < 6) {
				errorList.add("E-mail address too short.");
			}
			if (!user.getEmail().contains("@")) {
				errorList.add("E-mail address not correct.");
			}
		}

		// First name
		if (user.getFirstName().length() == 0) {
			errorList.add("First name not set.");
		} else {
			if (user.getFirstName().length() < 6) {
				errorList.add("First name too short.");
			}
			if (!Validation.isAlphaSpace(user.getFirstName())) {
				errorList.add("First name contains illegal character(s).");
			}
		}

		// Last name
		if (user.getLastName().length() == 0) {
			errorList.add("Last name not set.");
		} else {
			if (user.getLastName().length() < 6) {
				errorList.add("Last name too short.");
			}
			if (!Validation.isAlphaSpace(user.getLastName())) {
				errorList.add("Last name contains illegal character(s).");
			}
		}

		// Password
		if (user.getPassword().length() == 0) {
			errorList.add("Password not set.");
		} else {
			if (user.getPassword().length() < 6) {
				errorList.add("Password too short.");
			}
			if (!Validation.isAlphanumeric(user.getPassword())) {
				errorList.add("Password contains illegal character(s).");
			}
		}
		//if validate, send to RMI
		if(errorList.isEmpty()){
			UUID sessionId = null;
			try {
				sessionId = RMIServerComm.get().getSessionId();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			boolean answer = false;
			try {
				answer = RMIServerComm.get().getPublicInterface(sessionId).getUserDAO().saveUser(user);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(answer == false){
				errorList.add("Couldn't connect to server");
			}
		}
		//
		
		return errorList;
	}
	
	@Override
	public void doUpdate(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws ServletException, IOException {
		
	}

	@Override
	public void doDelete(HttpServletRequest request,
			HttpServletResponse response, Integer id) throws ServletException, IOException {
		
	}

	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response, Integer id) throws ServletException, IOException {
		
	}
	@Override
	public void doElse(HttpServletRequest request, 
			HttpServletResponse response, Integer id) throws ServletException, IOException {
		
	}
}
