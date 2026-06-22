package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProjectsDao;
import dto.Projects;



/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
@MultipartConfig
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String UPLOAD_DIR = "/f3/uploadImages";
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
		// 画像ファイルのアップロード
		Part filePart = request.getPart("file");
		
		if (filePart == null || filePart.getSize() == 0) {
			response.getWriter().write("ファイルがありません");
			return;
		}
		
		// 保存先ディレクトリ取得
		String UPLOAD_DIR = getServletContext().getRealPath("/uploadImages");
		
		// ディレクトリ作成
			File dir = new File(UPLOAD_DIR);
			if (!dir.exists()) {
				dir.mkdirs();
					}
		
		// ファイル名取得
			String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
			
		
		
		// 保存パス(物理)
			String filePath = UPLOAD_DIR + File.separator + fileName;
			
		// URL用パス (DB保存用)
			String imageUrl = "uploadImages/" + fileName;
			
			
		// ファイル保存
			filePart.write(filePath);
			
			
		
		// リクエストパラメータを取得する。 
		String theme = request.getParameter("theme");
		int number = 3;
		try {
		number = Integer.parseInt(request.getParameter("number"));
		} catch (Exception e) {
			number = 3;
		}
		
		// セッションスコープでユーザーIDを取得する
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			response.sendRedirect("/f3/LoginServlet");
			return;
		}
		
		String userId = (String) session.getAttribute("userId");
		if(userId == null) {
			response.sendRedirect("/f3/LoginServlet");
			return;
		}
		
		
		
		// Daoを使って上記の変数をデータベースに登録する。
		ProjectsDao pDao = new ProjectsDao();
		boolean result = pDao.insert(new Projects(0, userId, imageUrl, number, theme, "yyyy-MM-dd HH:mm:ss"));
		
		// コンソールで登録結果を確認するための
		System.out.println(result);
		System.out.println(filePath);
		// post.jspにフォワードする
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/post.jsp");
		dispatcher.forward(request, response);
	}

}
