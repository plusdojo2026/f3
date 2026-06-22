package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BanDao;

/**
 * Servlet implementation class BanServlet
 */
@WebServlet("/BanServlet")
public class BanServlet extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//JSPから遅れらて来たuserIdを取得する
		String userId =request.getParameter("userId");
		//DAO生成
		BanDao dao = new BanDao();
		//BANを実行
		if(dao.banUser(userId)) {

			request.setAttribute("msg","ユーザーをBANしました");

		}else {

			request.setAttribute("msg","BANに失敗しました");
		}

		request.getRequestDispatcher("/WEB-INF/jsp/ban.jsp")
		.forward(request, response);
	
	}

}
