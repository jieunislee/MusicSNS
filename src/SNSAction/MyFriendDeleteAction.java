package SNSAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyfriendDAO;
import vo.MyfriendVO;

/**
 * Servlet implementation class MyFriendDeleteAction
 */
@WebServlet("/sns/myfriend_delete.korea")
public class MyFriendDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String friendid = request.getParameter("friendid"); 
		String myid = request.getParameter("myid");
		MyfriendVO vo = new MyfriendVO();
		vo.setMyid(myid);
		vo.setFriendid(friendid);
		MyfriendDAO.getInstance().deleteList(vo);
	}
}
