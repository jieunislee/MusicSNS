package LoginAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/login/logout.korea")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("idx");
		request.getSession().removeAttribute("authority");
		request.getSession().removeAttribute("id");
		RequestDispatcher disp = request.getRequestDispatcher("../music/list.korea"); //메인으로 이동
		disp.forward(request, response);
	}
}
