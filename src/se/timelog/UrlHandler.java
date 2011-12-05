package se.timelog;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import se.timelog.pages.Page;
import se.timelog.pages.User;

/**
 * Servlet implementation class UrlHandler
 */
public class UrlHandler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Map<String, Page> pages = new HashMap<String, Page>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrlHandler() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	pages.put("user", new User());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI().toString().replace( "/Timelog/", "" );
		String[] pathSplitted = path.split("/");
		List<String> remainingPath = Arrays.asList(pathSplitted);
		String pageName = remainingPath.get(0);
		
		Page page = pages.get(pageName);
		
		if( page != null ){
			page.doStuff(remainingPath, request, response);
		}else{
			response.sendError(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
