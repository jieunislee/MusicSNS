package PlaylistAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.PlaylistDAO;
import util.Paging;

import vo.PlaylistVO;

/**
 * Servlet implementation class OtherListAction
 */
@WebServlet("/music/otherlist_list.korea")
public class OtherListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//페이징 처리전List<PlaylistVO> list = PlaylistDAO.getInstance().select(resultidx);
		String page = request.getParameter("page"); // ~.korea?page=2
		int currentPage = 1; // 현재 페이지 번호 (파라미터가 없을 것도 가정) 없으면 기본 1페이지
		if( page != null && page.equals("") == false ) {
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 10;
		int totalSize = PlaylistDAO.getInstance().myselectCount(Integer.parseInt(request.getParameter("idx")) );
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		map.put("memberidx",   Integer.parseInt(request.getParameter("idx")) );
		List<PlaylistVO> list = PlaylistDAO.getInstance().myselect(map);
		request.setAttribute("paging", paging);
		
		request.setAttribute("idx", Integer.parseInt(request.getParameter("idx")) );
		request.setAttribute("url", "../music/otherlist_list.korea");
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("playlist_list.jsp");
		disp.forward(request, response);
	}
}
