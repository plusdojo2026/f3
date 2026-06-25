package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RelayDao;
import dto.Relay;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();

	    String userId = (String) session.getAttribute("userId");
	    System.out.println("ログインユーザーuserId=" + userId);

	    // ★ここ変更
	    RelayDao dao = new RelayDao();

	    Relay relay = dao.findByUserId(userId);
	    
	    System.out.println("relay=" + relay);

	    session.setAttribute("relay", relay);
	    String user_id = relay.getUser_id();
	    int process_count = relay.getProcess_count();
	    int project_id = relay.getProject_id();
	    int redraw_count = relay.getRedraw_count();
	    String relay_image_url = relay.getRelay_image_url();
	    LocalDateTime deadline_at = relay.getDeadline_at();
	    
	    session.setAttribute("user_id", user_id);
	    session.setAttribute("process_count", process_count);
	    session.setAttribute("project_id", project_id);
	    session.setAttribute("redraw_count", redraw_count);
	    session.setAttribute("relay_image_url", relay_image_url);
	    session.setAttribute("deadline_at", deadline_at);

	    System.out.println(relay_image_url);
	    RequestDispatcher dispatcher =
	            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");

	    dispatcher.forward(request, response);
	}
}
