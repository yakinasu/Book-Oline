package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BookSearchLogic;
import model.BookBean;

/**
 * Servlet implementation class searchBookInfoServlet
 */
public class BookSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public BookBean bookBean = new BookBean();

	public BookSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookSearchLogic bookSearchLogic = new BookSearchLogic();
			request.setCharacterEncoding("UTF8");
			if (request.getParameter("upload") != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookUpdate.html");
				dispatcher.forward(request, response);
				return;
			}
			String isbn = request.getParameter("isbn");
			System.out.println(isbn);
			bookBean = bookSearchLogic.selectBookdb(isbn);
			if (bookBean == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/error/dbError.html");
				dispatcher.forward(request, response);
				return;
			} else {
				request.setAttribute("bookList", bookBean);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookSearchResult.jsp");
				dispatcher.forward(request, response);
				return;

			}
		} catch (Exception e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/error/dbError.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
