package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 開発用。画面と画面をつなぐとき不要なら削除せよ。
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する。
		// 画像ファイルの格納場所がわかり次第書け
		String theme = request.getParameter("number");
		String number = request.getParameter("number");
		
		// Daoを使って上記の変数をデータベースに登録する。
		
		// post.jspにフォワードする
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
	}

}
