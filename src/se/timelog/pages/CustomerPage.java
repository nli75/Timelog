package se.timelog.pages;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Customer;
import se.timelog.rmi.MockupRMI;

public class CustomerPage extends RestPage {

	@Override
	public void doCreate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.getRequestDispatcher("/WEB-INF/views/customer_create.jsp").forward(request, response);
		} else {
			String name;
			
			name = request.getParameter("name");
			
			Customer customer = new Customer();
			customer.setName(name);

			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorList  = mockupRMI.customerCreate(customer);
			if (errorList.isEmpty()) {
				request.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(request, response);	
			} else {
				request.setAttribute("errorList", errorList);
				request.getRequestDispatcher("/WEB-INF/views/customer_create.jsp").forward(request, response);	
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
