package se.timelog.pages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Project;
import se.timelog.pages.RestPage;
import se.timelog.rmi.RMIServerComm;

/**
 * Servlet implementation class ProjectPage
 */

public class ProjectPage extends RestPage {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "project_create");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String name;
			int budget;
			int estimatedTime;
			
			name = request.getParameter("name");
			if (request.getParameter("budget").isEmpty()) {
				budget = 0;
			} else {
				budget = Integer.parseInt(request.getParameter("budget"));
			}
			if (request.getParameter("budget").isEmpty()) {
				estimatedTime = 0;
			} else {
				estimatedTime = Integer.parseInt(request.getParameter("estimatedTime"));
			}
			
			Project project = new Project();
			project.setName(name);
			project.setBudget(budget);
			project.setEstimatedTime(estimatedTime);
			
			ArrayList<String> errorList  = projectCreate(project);
			if (errorList.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);	
			} else {
				request.setAttribute("content", "project_create");
				request.setAttribute("errorList", errorList);
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
	
	public ArrayList<String> projectCreate(Project project) {

		ArrayList<String> errorList = new ArrayList<String>();

		// Name
		if (project.getName().isEmpty() || project.getName().length() == 0) {
			errorList.add("ProjectPage name not set.");
		} else {
			if (project.getName().length() < 6) {
				errorList.add("ProjectPage name too short.");
			}
			if (!Validation.isAlphanumeric(project.getName())) {
				errorList.add("ProjectPage name contains illegal character(s).");
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
				answer = RMIServerComm.get().getPublicInterface(sessionId).getProjectDAO().saveProject(project);
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

}