package SNSAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAO;

/**
 * Servlet implementation class MessageDeleteAction
 */
@WebServlet("/sns/msg_delete.korea")
public class MessageDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = 0;
		res = MessageDAO.getInstance().deleteList(idx);
		
		String result = "no";
		if(res != 0) {
			result = "yes";
		}
		
		String resultStr = String.format("[{'result':'%s'}]", result);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}

}
