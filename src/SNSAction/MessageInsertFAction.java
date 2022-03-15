package SNSAction;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageInsertFAction
 */
@WebServlet("/sns/msg_insert_form.korea")
public class MessageInsertFAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String receivedId = request.getParameter("receivedId");
		
		request.setAttribute("receivedId", receivedId);
		
		RequestDispatcher disp = request.getRequestDispatcher("msg_form.jsp");
		disp.forward(request, response);
	}

}
