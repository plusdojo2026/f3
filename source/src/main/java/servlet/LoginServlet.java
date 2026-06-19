package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDao;
import dto.Users;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String userId = request.getParameter("loginId");
				String password = request.getParameter("password");

				
				// DTO作成
				Users user = new Users(userId, password);
				
				// ログイン処理を行う
				UsersDao dao = new UsersDao();
				if (dao.isLoginOK(user)) { // ログイン成功
					// セッションスコープにIDを格納する
					HttpSession session = request.getSession();
					session.setAttribute("userId",userId);

					// メニューサーブレットにリダイレクトする
					response.sendRedirect("/f3/HomeServlet");
				} else { // ログイン失敗
					// エラーメッセージ
					request.setAttribute("errorMsg","ユーザーIDまたはパスワードが違います。");

					// ログイン画面へ戻す
					request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
					.forward(request, response);
				}
			}
}
