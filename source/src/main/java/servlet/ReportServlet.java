package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReportDao;
import dto.Report;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// リクエストパラメーターを取得する
		String reason = request.getParameter("reason");
		//リレーIDについてはProcessingRelayServlet完成後に書け
		HttpSession session = request.getSession();
		int relayId = (int) session.getAttribute("relay_id");
		
		// セッションスコープでユーザーIDを取得する
		
		if (session == null) {
			response.sendRedirect("/f3/LoginServlet");
			return;
		}
		
		String userId = (String) session.getAttribute("user_id");
		if(userId == null) {
			response.sendRedirect("/f3/LoginServlet");
			return;
		}
		
		// Daoを使って上記の変数をデータベースに登録する
		ReportDao rDao = new ReportDao();
		boolean result = rDao.insert(new Report(0, relayId, userId, reason, "yyyy-MM-dd HH:mm:ss"));
	}

}
