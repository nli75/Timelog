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

public class Project extends RestPage {
	
	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/views/project_create.jsp").forward(request, response);
		} else {
			String name, budget, estimated_time, customer;
			
			name			= request.getParameter("name");
			budget			= request.getParameter("budget");
			estimated_time	= request.getParameter("estimated_time");
			customer		= request.getParameter("customer");
			
			ProjectModel projectModel = new ProjectModel();
			projectModel.setName(name);
			projectModel.setBudget(budget);
			projectModel.setEstimated_time(estimated_time);
			projectModel.setCustomer(customer);
			
			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorlist  = mockupRMI.projectCreate(projectModel);
			if (errorlist.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);	
			} else {
				request.setAttribute("errors", errorlist);
				request.getRequestDispatcher("/WEB-INF/views/project_create.jsp").forward(request, response);	
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
