package SNSAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class IdSearchAction
 */
@WebServlet("/sns/id_list.korea")
public class IdSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String idsearch = request.getParameter("idsearch");
		List<MemberVO> list = MemberDAO.getInstance().selectList(idsearch);
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("../sns/id_list.jsp");
		disp.forward(request, response);
	}
}
