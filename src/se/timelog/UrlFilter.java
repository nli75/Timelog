package se.timelog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import se.timelog.pages.CustomerPage;
import se.timelog.pages.Page;
import se.timelog.pages.LoginPage;
import se.timelog.pages.ProjectPage;
import se.timelog.pages.RolePage;
import se.timelog.pages.SearchPage;
import se.timelog.pages.UserPage;

/**
 */
public class UrlFilter implements Filter {
 private Map<String, Page> pages = new HashMap<String, Page>();

    /**
     * Default constructor. 
     */
 public UrlFilter() {
		super();
		pages.put("user", new UserPage());
		pages.put("login", new LoginPage());
		pages.put("project", new ProjectPage());
		pages.put("search", new SearchPage());
		pages.put("customer", new CustomerPage());
		pages.put("role", new RolePage());
	}
   
      
 /**
  * @see Filter#destroy()
  */
 public void destroy() {
 }

 /**
  * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
  */
 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
  HttpServletRequest request = (HttpServletRequest)req;
  HttpServletResponse response = (HttpServletResponse)res;
  
  String path = request.getRequestURI().toString().replace( "/Timelog/", "" );
  
  String [] pathSplitted = path.split("/");
  
  List<String> remainingPath = new ArrayList<String>(Arrays.asList(pathSplitted));
  
  String pageName = remainingPath.get(0);
	
	Page page = pages.get(pageName);
System.err.println(page);
  
 
  
  if( page != null ){
   page.doStuff(remainingPath, request, response);
  }else{
   chain.doFilter(request, response);
  }
 }

 /**
  * @see Filter#init(FilterConfig)
  */
 public void init(FilterConfig fConfig) throws ServletException {
 }

}