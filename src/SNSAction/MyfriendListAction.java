package SNSAction;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.MyfriendDAO;
import util.Paging;
import vo.MyfriendVO;



/**
 * Servlet implementation class MyfriendListAction
 */
@WebServlet("/sns/myfriend_list.korea")
public class MyfriendListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//페이지 처리전 List<MyfriendVO> list = MyfriendDAO.getInstance().select( (String)request.getSession().getAttribute("id")	);
		
		String page = request.getParameter("page"); // ~.korea?page=2
		
		int currentPage = 1; // 현재 페이지 번호 (파라미터가 없을 것도 가정) 없으면 기본 1페이지
		if( page != null && page.equals("") == false ) {
			currentPage = Integer.parseInt(page);
		}
		int pageSize = 10;
		int totalSize = MyfriendDAO.getInstance().myselectCount((String)request.getSession().getAttribute("id"));
		Paging paging = new Paging( pageSize, totalSize, currentPage );
		
		HashMap<String, String> map = new HashMap<>();
		map.put("startNo", paging.getStartNo()+"");
		map.put("endNo", paging.getEndNo()+"");
		map.put("myid",  (String)request.getSession().getAttribute("id"));
		List<MyfriendVO> list = MyfriendDAO.getInstance().myselect(map);
		request.setAttribute("paging", paging);
		
		request.setAttribute("id", (String)request.getSession().getAttribute("id"));
		request.setAttribute("url", "../sns/myfriend_list.korea");
		request.setAttribute("f_list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("Myfriend_list.jsp");
		disp.forward(request, response);
	}

}
