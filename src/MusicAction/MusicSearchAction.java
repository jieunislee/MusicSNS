package MusicAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MusicDAO;
import vo.MusicVO;

/**
 * Servlet implementation class MusicSearchAction
 */
@WebServlet("/music/search_list.korea")
public class MusicSearchAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		List<MusicVO> list = MusicDAO.getInstance().select(search);
		request.setAttribute("list", list);
		RequestDispatcher disp = request.getRequestDispatcher("music_list.jsp");
		disp.forward(request, response);
	}
}
