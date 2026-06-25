package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import dto.Detail;

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
			request.setCharacterEncoding("UTF-8");
			int project_id = Integer.parseInt(request.getParameter("projectId"));
			
			ReviewDao dao = new ReviewDao();
			List<Detail>detail = dao.detail(project_id);
			request.setAttribute("detail", detail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp");
			dispatcher.forward(request, response);

		}
		catch(Exception e){
			throw new ServletException(e);
		}

				
	}

}
