package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NoticeDao;
import dto.Notice;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		// 現在のユーザーのセッションを取得する
		HttpSession session = request.getSession();
		// セッションからユーザーIDを取り出す
		String userId = (String)session.getAttribute("userId");
		
		// NoticeDaoクラスのインスタンスを生成
		NoticeDao dao = new NoticeDao();
		// DaoのnoticeCallを呼び出す　引数でユーザーIDを返す
		// 通知をリストに格納
		List<Notice> list = dao.noticeCall(userId);
		
		// 取得した通知リストをリクエストスコープに保存
		request.setAttribute("noticelist",list);
		
		// 表示するJSPを指定
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		// JSPへフォワード
		dispatcher.forward(request, response);
	}
}
