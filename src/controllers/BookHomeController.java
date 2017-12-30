package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BookHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookHomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		if (request.getParameter("add") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookAdd.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if (request.getParameter("search") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookSearchHome.html");
			dispatcher.forward(request, response);
			return;
		}
		if (request.getParameter("upload") != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookUpdate.html");
			dispatcher.forward(request, response);
			return;
		}
	}
}
