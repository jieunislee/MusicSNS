package LoginAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginsAction
 */
@WebServlet("/login/login.korea")
public class LoginsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPw(pw);
		MemberVO res_vo = MemberDAO.getInstance().selectOne(vo);
		String param 		= ""; // param의 값
		String resultStr 	= ""; // 전송될 json 문자열
		if( res_vo == null) {
			param = "no";
		}
		else {
			param = "yes";
			// 정상이라면 '세션'에 데이터 저장
			HttpSession session = request.getSession();
			
			session.setAttribute("res_vo", res_vo);
			session.setAttribute("name", res_vo.getName()); 
			session.setAttribute("idx", res_vo.getIdx()); 
			session.setAttribute("authority", res_vo.getAuthority());
			session.setAttribute("id",res_vo.getId());
		}
		
		resultStr = String.format("[{'param':'%s'}]", param);
		// 이거 해줘야 됨~~ json으로 줄 때
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println( resultStr );
	}
}
