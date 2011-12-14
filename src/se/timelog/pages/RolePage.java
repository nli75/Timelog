package se.timelog.pages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Role;
import se.timelog.rmi.RMIServerComm;

public class RolePage extends RestPage {

	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "role_create");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String name;
			
			name = request.getParameter("name");
			
			Role role = new Role();
			role.setName(name);
			
			ArrayList<String> errorList  = roleCreate(role);
			if (errorList.isEmpty()) {
				request.setAttribute("content", "success");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("content", "role_create");
				request.setAttribute("errorList", errorList);
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			}
		}
	}

	public ArrayList<String> roleCreate(Role role) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Name
		if (role.getName().length() == 0) {
			errorList.add("Name not set.");
		} else {
			if (role.getName().length() < 6) {
				errorList.add("Name too short.");
			}
			if (!Validation.isAlphaSpace(role.getName())) {
				errorList.add("Name contains illegal character(s).");
			}
		}
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
				answer = RMIServerComm.get().getPublicInterface(sessionId).getRoleDAO().saveRole(role);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(answer == false){
				errorList.add("Couldn't connect to server");
			}
		}
		return errorList;
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
	@Override
	public void doElse(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
	}
}
