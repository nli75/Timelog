package se.timelog.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Search extends JspPage {

	@Override
	public void doStuff(List<String> remainingPath, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = null;
		//remainingPath.remove(0);
		if (remainingPath.size() > 1) {
			method = remainingPath.get(1); // Av någon anledning så fungerar inte förra raden så för tillfället har jag .get(1)
		}
		
		if (method == null) {
			request.setAttribute("content", "search");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		} else if ("result".equals(method)) {
			request.setAttribute("content", "search_result");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);			
		} else {
			request.setAttribute("content", "search");
			request.getRequestDispatcher("/WEB-INF/views/page_tpl.jsp").forward(request, response);
		}
		
	}

}
