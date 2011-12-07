package se.timelog.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Role;
import se.timelog.rmi.MockupRMI;

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
			
			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorList  = mockupRMI.roleCreate(role);
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
