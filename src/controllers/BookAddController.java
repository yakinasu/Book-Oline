package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BookAddLogic;
import model.BookBean;
import tool.ServletHelper;

public class BookAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String message = " ";
	public ServletHelper send = new ServletHelper();
	public BookBean bookBean = new BookBean();
	public ArrayList<BookBean> bookList = new ArrayList<BookBean>();

	public BookAddController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			BookAddLogic bookAddLogic = new BookAddLogic();
			request.setCharacterEncoding("UTF8");
			String bookTytle = request.getParameter("tytle");
			String isbn = request.getParameter("isbn");
			String page = request.getParameter("page");
			String author = request.getParameter("author");
			bookBean.setBean(isbn, bookTytle, page, author);
			if (!bookBean.validation()) {
				System.out.println("記入漏れあり");
				message = bookBean.getMessage();
				request.setAttribute("message", message);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/bookAdd.jsp");
				dispatcher.forward(request, response);
				return;
			}
			bookAddLogic.insertBookInfo(bookBean);
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/book/BookHome.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			send.sendDispatcher(request, response, "/view/error/dbError.html");
		}
	}
}
