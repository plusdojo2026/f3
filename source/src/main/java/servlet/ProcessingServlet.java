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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	    String image = request.getParameter("image");
	    
	    if (image == null || !image.contains(",")) {
	    	throw new ServletException("imageがnullです");
	    }
	    
	    if(!image.contains(",")) {
	    	throw new ServletException("image形式不正" + image);
	    }
	    // base64除去
	    String base64Data = image.split(",")[1];
	    byte[] imageBytes = Base64.getDecoder().decode(base64Data);

	    // 保存先
	    String UPLOAD_DIR = getServletContext().getRealPath("/uploadImages");

	    File dir = new File(UPLOAD_DIR);
	    if (!dir.exists()) {
	        dir.mkdirs();
	    }

	    String fileName = System.currentTimeMillis() + ".png";
	    String filePath = UPLOAD_DIR + File.separator + fileName;

	    // 保存
	    FileOutputStream fos = new FileOutputStream(filePath);
	    fos.write(imageBytes);
	    fos.close();

	    String imageUrl = "uploadImages/" + fileName;

	    String caption = request.getParameter("caption");

	    HttpSession session = request.getSession();
	    String user_id = (String) session.getAttribute("user_id");
	    int process_count = (int) session.getAttribute("process_count");
	    int project_id = (int) session.getAttribute("project_id");
	    
	    System.out.println("user_id=" + user_id);
	    System.out.println("project_id=" + project_id);
	    System.out.println("process_count=" + process_count);
	    System.out.println("caption=" + caption);
	    System.out.println("imageUrl=" + imageUrl);

	    HistoryDao hDao = new HistoryDao();
	    boolean result = hDao.setHistory(
	        new History(0, user_id, imageUrl, process_count, project_id, 1, caption, LocalDateTime.now())
	    );

	    System.out.println(result);

	    response.sendRedirect("/f3/HomeServlet");
	}

}
