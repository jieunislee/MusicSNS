package PlaylistAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlaylistDAO;
import vo.PlaylistVO;


/**
 * Servlet implementation class PlaylistInsertAction
 */
@WebServlet("/music/playlist_insert.korea")
public class PlaylistInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int musicidx = Integer.parseInt( request.getParameter("musicidx") );
		int memberidx = Integer.parseInt( request.getParameter("memberidx") );
		PlaylistVO vo = new PlaylistVO();
		vo.setMusicidx(musicidx);
		vo.setMemberidx(memberidx);
		
		// 이미 장바구니에 등록된 상품인지 확인 (select)
		PlaylistVO res_vo = PlaylistDAO.getInstance().selectOne( vo );
		
		String result = "no";
		if(res_vo == null ) {// 객체가 없으면 테이블에 없는 것!
			result = "yes"; // 돌려줄 결과 값
			PlaylistDAO.getInstance().insert(vo); // DB에 추가
		}
		
		String resultStr = String.format("[{'result':'%s'}]", result);
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().println(resultStr);
	}

}
