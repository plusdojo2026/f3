package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoryDao;
import dto.History;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 詳細ページにフォワードする
		try {


			// 表示する作品のプロジェクトID
			int project_id = 1;

			// DAO作成
			HistoryDao dao = new HistoryDao();

			// 加工履歴取得
			// すでにprocess_count順
			List<History> historyList = dao.getHistory(project_id);

			// 今表示している番号取得
			Integer index = (Integer)request.getSession().getAttribute("index");

			// 初回なら0番目
			if(index == null) {
				index = 0;
			}

			// 現在位置保存
			request.getSession().setAttribute("index", index);

			// 現在表示するデータ
			request.setAttribute("historyList",historyList);

			// ★最初に表示する番号
			request.setAttribute("index",index);

			// JSPへ移動
			request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request,response);
		}
		catch(Exception e){
			throw new ServletException(e);
		}

				
	}

}
