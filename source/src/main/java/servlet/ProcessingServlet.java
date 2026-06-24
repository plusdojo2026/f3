package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProjectsDao;
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
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/WEB-INF/jsp/processing.jsp");
		dispatcher.forward(request, response);
	}

}
