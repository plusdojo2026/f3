package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CurseDao;
import dto.Curse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// セッション取得
		HttpSession session = request.getSession();
		
		// ログイン中のユーザーID取得
		String userId =(String)session.getAttribute("userId");
		System.out.println("ログインユーザーuserId=" + userId);
		
		// CurseDAO生成
		CurseDao dao = new CurseDao();
		
		// 呪い情報取得
		Curse curse =dao.findByUserId(userId);
		
		System.out.println("curse=" + curse);
		System.out.println("requestに格納完了");
		
		// 呪いが存在したらJSPへ渡す
		if (curse != null) {
			//呪われている日時を取得
		    LocalDateTime curseDate = curse.getCurseDate();
		    //7日後か判定
		    if (curseDate.plusDays(7).isBefore(LocalDateTime.now())) {
		    	
		        dao.releaseCurse(curse.getCurseId());
		        
		        curse = null;
		    }
		}

		request.setAttribute("curse", curse);
		
		// ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}
}
