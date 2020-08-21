

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		HashMap<String, String> map = new HashMap<>(); 
		
		Enumeration names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement().toString();
			String value = session.getAttribute(name).toString();
			map.put(name, value);
		}
		
		request.setAttribute("session", map.toString());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("06_getSession_Servlet.jsp");
		dispatcher.forward(request, response);
	}

}
