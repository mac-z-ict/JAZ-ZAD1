package servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.setContentType("text/html");
		String name = request.getParameter("name");
		response.setContentType("text/plain");
		response.getWriter().println("Hell World " + name + " :] - doGet2");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		if (name == null || name.equals("")) {
			response.sendRedirect("/");
		}
		this.doGet(request, response);
	}
	
}
