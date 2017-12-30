package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BookUpdateLogic;

/**
 * Servlet implementation class UploadServlet
 */
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookUpdateController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookUpdateLogic bookUpdateLogic = new BookUpdateLogic();
			String key = request.getParameter("key");
			String isbn = request.getParameter("isbn");
			String record = request.getParameter("record");
			bookUpdateLogic.updateBookdb(key, isbn, record);
			response.sendRedirect("/bookOnline/view/book/BookHome.jsp");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/BookHome.jsp");
			//dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/error/dbError.html");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
