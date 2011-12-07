package se.timelog.pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Timelog;
import se.timelog.rmi.MockupRMI;

public class TimelogPage extends RestPage {

	@Override
	public void doCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("GET".equals(request.getMethod())) {
			request.setAttribute("content", "timelog_create");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else {
			String title = request.getParameter("title");
			String comment = request.getParameter("comment");
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date start = null;
			try {
				start = (Date)formatter.parse(request.getParameter("start"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int duration = Integer.parseInt(request.getParameter("duration"));
			int projectId = Integer.parseInt(request.getParameter("projectId"));
			Timelog timelog = new Timelog();
			timelog.setTitle(title);
			timelog.setComment(comment);
			timelog.setStart(start);
			timelog.setDuration(duration);
			timelog.setProjectId(projectId);

			MockupRMI mockupRMI = new MockupRMI();
			ArrayList<String> errorList  = mockupRMI.timelogCreate(timelog);
			if (errorList.isEmpty()) {
				request.setAttribute("content", "success");
				request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);	
			} else {
				request.setAttribute("content", "timelog_create");
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
