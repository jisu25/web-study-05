package web_study_05.unit02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String root = request.getContextPath();
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("<html><head><script>")
		.append("alert(\"로그아웃!\");</script></head></html>");
		
		response.sendRedirect(root + "/login/10_loginForm.jsp");
	}

}
