package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import dto.Users;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		// 入力値取得
		String userId =request.getParameter("userId");
		String userName =request.getParameter("userName");
		String password =request.getParameter("password");
		String email =request.getParameter("mailAddress");
		
		//DTO
		Users user =new Users(userId,userName,password,email,false,false);
		
		//登録処理
		UsersDao dao =new UsersDao();
		
		if (password.length() < 8) {

			request.setAttribute(
					"errorMsg",
					"パスワードは8文字以上で入力してください");

			request.getRequestDispatcher(
					"/WEB-INF/jsp/regist.jsp")
					.forward(request, response);

			return;
		}
		
		if (dao.isExistUserId(userId)) {

			request.setAttribute("errorMsg","このユーザーIDは既に使用されています");

			request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp")
			.forward(request, response);

			return;
		}
		
		if(dao.insert(user)) {
			//登録成功
			response.sendRedirect(
					request.getContextPath()+"/LoginServlet");
		}else {

			// 登録失敗
			request.setAttribute("errorMsg",
					"登録に失敗しました");

			request.getRequestDispatcher(
					"/WEB-INF/jsp/regist.jsp")
					.forward(request, response);
		}
	}
}