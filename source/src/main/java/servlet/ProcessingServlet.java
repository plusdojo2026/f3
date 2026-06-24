package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.HistoryDao;
import dao.ProjectsDao;
import dto.History;
import dto.Projects;
import dto.Relay;

/**
 * Servlet implementation class ProcessingServlet
 */
@WebServlet("/ProcessingServlet")
public class ProcessingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
				// セッションスコープでproject_idを取得する
				HttpSession session = request.getSession();
				
				if(session == null) {
					response.sendRedirect("/f3/LoginServlet");
					return;
				}
				Relay relay = (Relay) session.getAttribute("relay");
				// セッションスコープに格納
				request.setAttribute("relay", relay);
				int projectId = (int) session.getAttribute("project_id");
				String relay_image_url = (String) session.getAttribute("relay_image_url");
				String deadline = (String) session.getAttribute("deadline_at");
				
				
				System.out.println(relay_image_url);
				
				// Daoでテーマを取得する
				ProjectsDao pDao = new ProjectsDao();
				String result = pDao.selectTheme(new Projects(projectId, "theme"));
				
				// リクエストスコープに取得した要素を格納する
				request.setAttribute("theme", result);
				request.setAttribute("relay_image_url", relay_image_url);
				request.setAttribute("deadline", deadline);
				
				
				
				
				
				// jspにフォワード
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/WEB-INF/jsp/processing.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 画像ファイルの受け取り
		Part filePart = request.getPart("image");
		
		if (filePart == null || filePart.getSize() == 0) {
			response.getWriter().write("ファイルがありません");
			return;
		}
		
		// 保存先ディレクトリ取得
		String UPLOAD_DIR = getServletContext().getRealPath("/uploadImages");
		
		// ディレクトリ作成
			File dir = new File(UPLOAD_DIR);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			// ファイル名取得
			String fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
			
			// 保存パス（物理）
			String filePath = UPLOAD_DIR + File.separator + fileName;
			
			// URL用パス (DB保存用)
			String imageUrl = "uploadImages/" + fileName;
		
		// リクエストパラメーターを取得
			String caption = request.getParameter("caption");
		
		// セッションスコープを取得
		
		// Daoを使って上記の変数をdata baseに登録する
		HistoryDao hDao = new HistoryDao();
		boolean result = hDao.setHistory(new History());
		
		// コンソールで登録結果を確認するため
		System.out.println(result);
		System.out.println(filePath);
		
		
		
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/processing.jsp");
		dispatcher.forward(request, response);
	}

}
