package SNSAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApplyfriendDAO;
import vo.ApplyfriendVO;

/**
 * Servlet implementation class ApplyInsertAction
 */
@WebServlet("/sns/apply_insert.korea")
public class ApplyInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ApplyfriendVO vo = new ApplyfriendVO();
		vo.setSendid(	(String)request.getSession().getAttribute("id")	);	
		vo.setSendname(	(String)request.getSession().getAttribute("name")	);
		vo.setReceiveid( request.getParameter("receiveid")	 );
		
		ApplyfriendVO res_vo = ApplyfriendDAO.getInstance().selectOne( vo );
		
		String result = "no";
		if(res_vo == null ) {// 객체가 없으면 테이블에 없는 것!
			result = "yes"; // 돌려줄 결과 값
			ApplyfriendDAO.getInstance().insert( vo );
		}
		String resultStr = String.format("[{'result':'%s'}]", result);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}
}
