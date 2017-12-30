package model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import tool.Constants;


public class BookBean {
	@NotNull(message = "何か入力してください")
	@Size(min = 1, max = 20)
	private String isbn;
	@NotNull(message = "何か入力してください")
	@Size(min = 1, max = 50)
	private String bookTytle;
	@NotNull(message = "何か入力してください")
	@Min(1)
	@Max(2000)
	private String totalPage;
	@NotNull(message = "何か入力してください")
	@Size(min = 1, max = 50)
	private String author;
	private String message = "";

	public BookBean(String isbn, String bookTytle, String totalPage, String author) {
        this.isbn = isbn;
        this.bookTytle = bookTytle;
        this.totalPage = totalPage;
        this.author = author;
    }

	public BookBean() {
	}

	public	String getIsbn() {
		return isbn;
	}

	public	String getBookTytle() {
		return bookTytle;
	}

	public	String getTotalPage() {
		return totalPage;
	}

	public	String getAuthor() {
		return author;
	}

	public	void setIsbn(String isbn) {
		this.isbn =  isbn;
	}

	public	void setBookTytle(String bookTytle) {
		this.bookTytle = bookTytle;
	}

	public	void setTotalPage(String totalPage) {
		this.totalPage =  totalPage;
	}

	public	void setAuthor(String author) {
		this.author = author;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public	String getMessage() {
		return message;
	}

	public void setBean(String isbn, String bookTytle, String totalPage, String author) {
        this.setBookTytle(isbn);
		this.setIsbn(bookTytle);
		this.setTotalPage(totalPage);
		this.setAuthor(author);
	}

	public boolean validation() {
		// null Check
		if (this.getAuthor() == null || this.getIsbn() == null || this.getBookTytle() == null
				|| this.getTotalPage() == null) {
			this.setMessage("No string");
			return false;
		}
		// Author 1~50文字
		if (this.getAuthor().length() > Constants.MAX_AUTHOR) {
			System.out.println("Authorの文字数がおかしい");
			this.setMessage("Author is wrong");
			return false;
		}
		// BookTitle 1~100文字
		if (this.getBookTytle().length() >= Constants.MAX_BOOK_TITLE) {
			System.out.println("BookTitleがおかしい");
			this.setMessage("BookTitle is wrong");
			return false;
		}
		// Isbn 1~20文字
		if (this.getIsbn().length() >= Constants.MAX_ISBN) {
			System.out.println("ISBNがおかしい");
			this.setMessage("ISBN code is wrong");
			return false;
		}
		// 1~2000文字
		if (this.getTotalPage().length() >= Constants.MAX_BOOK_TOTAL_PAGE || this.getTotalPage().matches("^[a-zA-Z]+$")) {
			System.out.println("TotalPageがおかしい");
			this.setMessage("TotalPage is wrong");
			return false;
		}
		return true;
	}

}
