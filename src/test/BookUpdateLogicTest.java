package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import logic.BookUpdateLogic;
import model.BookBean;

public class BookUpdateLogicTest {

	public BookBean bookBean = new BookBean();

	@Before
	public void before() {
	bookBean.setBean("test", "test", "123", "test");
	}

	@Test
	public void testUpdateBookInfo() {
		try {
			BookUpdateLogic bookUpdateLogic = new BookUpdateLogic();
			bookUpdateLogic.updateBookdb("title", "test", "title");
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}

}
