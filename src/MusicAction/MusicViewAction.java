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

import dao.CommentsDAO;
import dao.MusicDAO;
import util.Paging;
import vo.CommentsVO;
import vo.MusicVO;


/**
 * Servlet implementation class MusicViewAction
 */
@WebServlet("/music/view.korea")
public class MusicViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx = Integer.parseInt( request.getParameter("idx") );
		String name = request.getParameter("name");//작성자이름
		MusicVO vo = MusicDAO.getInstance().selectOne( idx );
		vo.setName(name);
		request.setAttribute("vo", vo);
		
		//페이징 전 List<CommentsVO> list = CommentsDAO.getInstance().select(idx);
		
		String page = request.getParameter("page"); // ~.korea?page=2
		int currentPage = 1; // 현재 페이지 번호 (파라미터가 없을 것도 가정) 없으면 기본 1페이지
		if( page != null && page.equals("") == false ) {
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 5;
		int totalSize = CommentsDAO.getInstance().CommentsCount(Integer.parseInt(request.getParameter("idx")) );
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("startNo", paging.getStartNo());
		map.put("endNo", paging.getEndNo());
		map.put("memberidx",   Integer.parseInt(request.getParameter("idx")) );
		List<CommentsVO> list = CommentsDAO.getInstance().select(map);
		request.setAttribute("paging", paging);
		
		request.setAttribute("name",name);
		request.setAttribute("idx", Integer.parseInt(request.getParameter("idx")) );
		request.setAttribute("url", "../music/view.korea");
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("music_content.jsp");
		disp.forward(request, response);
	}
}
