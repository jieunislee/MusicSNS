package CommentsAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentsDAO;

/**
 * Servlet implementation class CommentsGoodpointAddAction
 */
@WebServlet("/music/comments_goodpoint_add.korea")
public class CommentsGoodpointAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt( request.getParameter("idx") );
		String name = request.getParameter("name");//작성자이름
		
		CommentsDAO.getInstance().update(idx);
		
		String resultStr = String.format("[{'name':'%s'}]", name);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}
}
