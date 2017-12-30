package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import logic.BookSearchLogic;
import model.BookBean;

public class BookSearchLogicTest {
	public BookBean bookBean = new BookBean();

	@Before
	public void before() {
	bookBean.setBean("test", "test", "123", "test");
	}

	@Test
	public void testSearchBookInfo() {
		try {
			BookSearchLogic bookSearchLogic = new BookSearchLogic();
			bookSearchLogic.selectBookdb("test");
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}

}
