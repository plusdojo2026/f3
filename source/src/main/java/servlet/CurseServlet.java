package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CurseDao;
import dto.Curse;

/**
 * Servlet implementation class CurseServlet
 */
@WebServlet("/CurseServlet")
public class CurseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CurseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				
				// プロジェクトID取得
				int projectId =Integer.parseInt(request.getParameter("projectId"));
				
				// 呪われるユーザーID取得
				String userId =request.getParameter("userId");
				
				// 未加工画像URL取得
				String rawImageUrl =request.getParameter("rawImageUrl");
				
				// DTO生成
				Curse curse =new Curse(0,projectId,userId,rawImageUrl);  
				
				// DAO生成
				CurseDao dao =new CurseDao();
				
				// 呪い登録
				if(dao.insert(curse)) {

					// 成功メッセージ
					request.setAttribute("msg","呪いを発動しました");
				}
				else {
					// 失敗メッセージ
					request.setAttribute("msg","呪い発動失敗");
				}
				// ホーム画面へ戻る
				request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);	
	}
	
	
}
