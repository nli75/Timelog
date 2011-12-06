package se.timelog.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.timelog.ProjectModel;
import se.timelog.rmi.MockupRMI;

/**
 * Servlet implementation class Project
 */

public class ProjectPage extends RestPage {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "project_create");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String name, budget, estimated_time, customer;
			
			name			= request.getParameter("name");
			budget			= request.getParameter("budget");
			estimated_time	= request.getParameter("estimated_time");
			customer		= request.getParameter("customer");
			
			Project project = new Project();
			project.setName(name);
			project.setBudget(budget);
			project.setEstimated_time(estimated_time);
			project.setCustomer(customer);
			
			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorlist  = mockupRMI.projectCreate(projectModel);
			if (errorlist.isEmpty()) {
				request.setAttribute("content", "success");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("content", "project_create");
				request.setAttribute("errorList", errorlist);
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
