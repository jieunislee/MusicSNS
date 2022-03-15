package SNSAction;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDAO;
import vo.MessageVO;

/**
 * Servlet implementation class MessageSendAction
 */
@WebServlet("/sns/msg_insert.korea")
public class MessageInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String receivedId = request.getParameter("receivedId");
		int sendIdx = Integer.parseInt(request.getParameter("sendIdx"));
		String sendId = request.getParameter("sendId");
		String msg = request.getParameter("msg");
		
		
		MessageVO vo = new MessageVO();
		vo.setReceivedId(receivedId);
		vo.setSendIdx(sendIdx);
		vo.setSendId(sendId);
		vo.setMsg(msg);
		
		MessageDAO.getInstance().insert(vo);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("window.close();");
		out.println("</script>");
	}

}
