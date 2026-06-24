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
				HttpSession session = request.getSession(false);
				
				if(session == null) {
					response.sendRedirect("/f3/LoginServlet");
					return;
				}
				int projectId = (int) session.getAttribute("projectId");
				
				// Daoでテーマを取得する
				ProjectsDao pDao =new ProjectsDao();
				boolean result = pDao.selectTheme(new Projects(projectId, "theme"));
				
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
