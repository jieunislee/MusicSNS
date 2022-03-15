package PlaylistAction;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlaylistDAO;


/**
 * Servlet implementation class PlaylistDeleteAction
 */
@WebServlet("/music/playlist_delete.korea")
public class PlaylistDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String idx = request.getParameter("idx");
		int resultidx = Integer.parseInt(idx);
		PlaylistDAO.getInstance().deleteList(resultidx);
	}
}
