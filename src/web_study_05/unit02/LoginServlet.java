package web_study_05.unit02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = "pinksung";
		String pwd = "1234";
		String name = "성윤정";
		
		String root = request.getContextPath();
		String head = request.getHeader("REFERER");
		
		HttpSession session = request.getSession();
		
		if(id.equals(request.getParameter("id")) && pwd.equals(request.getParameter("pwd"))) {
			session.setAttribute("loginUser", name);
			response.sendRedirect(root + "/login/10_main.jsp");
		} else {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("<html><head><script type=\"text/javascript\">alert(\"아이디 또는 비밀번호가 틀렸습니다.\");</script></head></html>");
			response.sendRedirect(head);
		}
	}

}
