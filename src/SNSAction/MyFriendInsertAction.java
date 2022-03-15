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
 * Servlet implementation class MyFriendInsertAction
 */
@WebServlet("/sns/myfriend_insert.korea")
public class MyFriendInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MyfriendVO vo = new MyfriendVO();
		
		vo.setMyid((String)request.getSession().getAttribute("id"));
		vo.setMyname( (String)request.getSession().getAttribute("name")	);
		vo.setFriendname( request.getParameter("friendname")	);
		vo.setFriendid( request.getParameter("friendid"));
		MyfriendVO res_vo = MyfriendDAO.getInstance().selectOne( vo );
		
		String result = "no";
		if(res_vo == null ) {
			result = "yes"; 
			MyfriendDAO.getInstance().insert( vo );                                      
			vo.setMyid( request.getParameter("friendid"));      //내 상대방에게도 내가친구라는걸 보이기위해 반대로 삽입
			vo.setMyname( request.getParameter("friendname")	);						//내 로그인 세션인덱스로 내친구리스트를 보여주기때문에
			vo.setFriendname((String)request.getSession().getAttribute("name"));		// 유저1이 유저2를 친추해도 유저2는 유저1이 내친구리스트에 없었기때문에
			vo.setFriendid( (String)request.getSession().getAttribute("id"));
			MyfriendDAO.getInstance().insert( vo );
		}
		
		String resultStr = String.format("[{'result':'%s'}]", result);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}
}
