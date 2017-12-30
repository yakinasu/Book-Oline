package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * ホーム画面に変遷
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");

		String user = request.getParameter("userName");
		String password = request.getParameter("password");
		if(user.equals("test") && password.equals("1234")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/BookHome.jsp");
			dispatcher.forward(request, response);
		}
		else if (user.equals("kanri") && password.equals("1234")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/adminHome.html");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/login/LoginFailed.html");
			dispatcher.forward(request, response);
		}

	}

	/**
	 *ユーザー新規登録
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		// result.jsp にページ遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.html");
		dispatcher.forward(request, response);
	}

}
