package CommentsAction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentsDAO;
import vo.CommentsVO;

/**
 * Servlet implementation class CommentsInsertResultAction
 */
@WebServlet("/music/comments_insert.korea")
public class CommentsInsertResultAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String c_content = request.getParameter("c_content");
		int musicidx = Integer.parseInt(request.getParameter("musicidx"));
		
		CommentsVO vo = new CommentsVO();
		vo.setC_name((String)request.getSession().getAttribute("name"));
		vo.setC_content(c_content);
		vo.setC_goodpoint(0);
		vo.setMusicidx(musicidx);
		vo.setMemberidx((int)request.getSession().getAttribute("idx"));
		
		CommentsDAO.getInstance().insert( vo );
		
		RequestDispatcher disp = request.getRequestDispatcher("view.korea?idx="+musicidx);
		disp.forward(request, response);
	}
}
