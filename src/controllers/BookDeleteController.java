package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BookDeleteLogic;
import model.BookBean;

/**
 * Servlet implementation class BookDeleteServlet
 */
public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BookBean bookBean = new BookBean();

	public BookDeleteController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookDeleteLogic bookDeleteLogic = new BookDeleteLogic();
			String isbn = request.getParameter("isbn");
			System.out.println(isbn);
			bookDeleteLogic.deleteBookdb(isbn);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/BookHome.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/error/dbError.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
