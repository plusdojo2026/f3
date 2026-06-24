package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CensorshipDao;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int admin_id = (int)session.getAttribute("admin_id");
		int project_id = Integer.parseInt(request.getParameter("project_id"));
		String user_id = request.getParameter("user_id");
		String source = request.getParameter("source");
		String action = request.getParameter("action");
		
		if("許可".equals(action)) {
			CensorshipDao dao = new CensorshipDao();
			boolean result = dao.authorize(project_id,user_id,source,admin_id);
			if (result) {
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().println("<script>alert('許可に成功しました'); location.href='MenuServlet';</script>");
	        } else {
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().println("<script>alert('許可に失敗しました'); history.back();</script>");
	        }
		}else if("取り消し".equals(action)) {
			CensorshipDao dao = new CensorshipDao();
			boolean result = dao.undo(project_id,user_id,admin_id);
			if (result) {
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().println("<script>alert('取り消しに成功しました'); location.href='MenuServlet';</script>");
	        } else {
	            response.setContentType("text/html; charset=UTF-8");
	            response.getWriter().println("<script>alert('取り消しに失敗しました'); history.back();</script>");
	        }
		}
		
		
		
	}

}
