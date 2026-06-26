package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.HistoryDao;
import dao.ProjectsDao;
import dto.History;
import dto.Projects;


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
	
				// セッションスコープから取得
				HttpSession session = request.getSession();
				String user_id = (String) session.getAttribute("user_id");
			    int process_count = (int) session.getAttribute("process_count");
			    int project_id = (int) session.getAttribute("project_id");
			    int redraw_count = (int) session.getAttribute("redraw_count");
			    String relay_image_url = (String) session.getAttribute("relay_image_url");
			    LocalDateTime deadline_at = (LocalDateTime) session.getAttribute("deadline_at");
				
				
				
				// Daoでテーマを取得する
				ProjectsDao pDao = new ProjectsDao();
				String theme = (String) pDao.selectTheme(new Projects(project_id, "theme"));
				
				// テーマをセッションスコープに格納
				session.setAttribute("theme", theme);
				
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
		String image = request.getParameter("image");
		
		// "data:image/png;base64," を除去
		String base64Data = image.split(",")[1];

		// デコード
		byte[] imageBytes = Base64.getDecoder().decode(base64Data);

		// ファイル保存
		FileOutputStream fos = new FileOutputStream("保存パス.png");
		fos.write(imageBytes);
		fos.close();
		
		// 保存先ディレクトリ取得
		String UPLOAD_DIR = getServletContext().getRealPath("/uploadImages");
		
		// ディレクトリ作成
			File dir = new File(UPLOAD_DIR);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			// ファイル名取得
			String fileName = System.currentTimeMillis() + "_eImage";
			
			// 保存パス（物理）
			String filePath = UPLOAD_DIR + File.separator + fileName;
			
			// URL用パス (DB保存用)
			String imageUrl = "uploadImages/" + fileName;
		
		// リクエストパラメーターを取得
			String caption = request.getParameter("caption");
		
		// セッションスコープを取得
			HttpSession session = request.getSession();
			
			String user_id = (String) session.getAttribute("user_id");
		    int process_count = (int) session.getAttribute("process_count");
		    int project_id = (int) session.getAttribute("project_id");
		    int redraw_count = (int) session.getAttribute("redraw_count");
		    String relay_image_url = (String) session.getAttribute("relay_image_url");
		    LocalDateTime deadline_at = (LocalDateTime) session.getAttribute("deadline_at");
			System.out.println("hawai");
			
		// Daoを使って上記の変数をdata baseに登録する
		HistoryDao hDao = new HistoryDao();
		boolean result = hDao.setHistory(new History(0, user_id, imageUrl, process_count, project_id, 1, caption, LocalDateTime.now()));
		
		// コンソールで登録結果を確認するため
		System.out.println(result);
		System.out.println(filePath);
		response.sendRedirect("/f3/HomeServlet");
	}

}
