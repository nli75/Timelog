package se.timelog;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UrlHandler
 */
@WebServlet("/UrlHandler")
public class UrlHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UrlHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//test 1
		//response.getWriter().write("skriv i browsern");
		System.out.println("helllooo2");
		
		//test 2. skriv till view
		request.setAttribute("namn", "Tobias");
		request.getSession().setAttribute("namn", "Tobias");
		
		request.getRequestDispatcher("WEB-INF/views/admin_create_user.jsp").forward(request, response);
		
		//request.getQueryString()
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
