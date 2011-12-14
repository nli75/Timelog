package se.timelog.pages;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.kyh.ad10.timeloggers.server.entities.Timelog;
import se.timelog.rmi.RMIServerComm;

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
			Timelog timelog = new Timelog();
			timelog.setTitle(title);
			timelog.setComment(comment);
			timelog.setStart(start);
			timelog.setDuration(duration);

			ArrayList<String> errorList  = timelogCreate(timelog);
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

	public ArrayList<String> timelogCreate(Timelog timelog) {
		ArrayList<String> errorList = new ArrayList<String>();
		// Title
		if (timelog.getTitle().length() == 0) {
			errorList.add("Title not set.");
		} else {
			if (timelog.getTitle().length() < 6) {
				errorList.add("Title too short.");
			}
			if (!Validation.isAlphaSpace(timelog.getTitle())) {
				errorList.add("Title contains illegal character(s).");
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
				answer = RMIServerComm.get().getPublicInterface(sessionId).getTimelogDAO().saveTimeLog(timelog);
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
