package se.timelog.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RestPage extends Page {

	public void realDoStuff(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//remainingPath.remove(0);
		String method = remainingPath.get(1); // Av någon anledning så fungerar inte förra raden så för tillfället har jag .get(1)
		
		if ("create".equals(method)){
			doCreate(request, response);
		} else if ("update".equals(method)){
			doUpdate(request, response);
		} else if ("delete".equals(method)){
			doDelete(request, response);
		} else if ("get".equals(method)){
			doGet(request, response);
		}else{
			doElse(request, response);
		}
		
	}
	
	public abstract void doCreate(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;
	public abstract void doUpdate(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;
	public abstract void doDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;
	public abstract void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;
	public abstract void doElse(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException;

	
}
