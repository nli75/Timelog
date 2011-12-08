package se.timelog.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Page {

	public void doStuff(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if( doAuthorize(remainingPath, request, response) )
			realDoStuff(remainingPath, request, response);
	}
	public abstract void realDoStuff(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	public boolean doAuthorize(List<String> remainingPath, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if ( request.getSession().getAttribute("username") == null ) {
			response.sendRedirect("/Timelog");
			return false;
		}
		return true;
	}

}
