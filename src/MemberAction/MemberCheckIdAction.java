package MemberAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.korea")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<MemberVO> list = null;
		String id = request.getParameter("id");
		
		list = MemberDAO.getInstance().selectList(id);
		
		String res = "no"; // 회원가입이 불가능! (존재)
		
		if( list.size() == 0) {
			res = "yes";
		}
		
		response.setContentType("text/plain; charset=utf-8"); 
		
		String resultStr = String.format("[{'result':'%s'}, {'id':'%s'}]", res, id);
		
		response.getWriter().println(resultStr);
		
	}

}
