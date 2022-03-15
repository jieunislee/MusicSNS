package MusicAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicDAO;

import util.Paging;
import vo.MusicVO;



/**
 * Servlet implementation class MusicListAction
 */
@WebServlet("/music/list.korea")
public class MusicListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//페이징처리 안했을때List<MusicVO> list = MusicDAO.getInstance().select();
		
		String page = request.getParameter("page"); // ~.korea?page=2
		
		int currentPage = 1; // 현재 페이지 번호 (파라미터가 없을 것도 가정) 없으면 기본 1페이지
		if( page != null && page.equals("") == false ) {
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 9;
		int totalSize = MusicDAO.getInstance().selectCount();
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		
		HashMap<String, String> map = new HashMap<>();
		map.put("startNo", paging.getStartNo()+""); // int를 문자열로 만들었음
		map.put("endNo", paging.getEndNo()+"");
		List<MusicVO> list = MusicDAO.getInstance().select(map);
		request.setAttribute("paging", paging);
		
		

		request.setAttribute("url", "../music/list.korea");
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("music_list.jsp");
		disp.forward(request, response);
	}
}
