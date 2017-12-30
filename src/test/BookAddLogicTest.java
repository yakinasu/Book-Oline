package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import logic.BookAddLogic;
import model.BookBean;

public class BookAddLogicTest {

	public BookBean bookBean = new BookBean();

	@Before
	public void before() {
		bookBean.setBean("test", "test", "123", "test");
	}

	@Test
	public void testInsertBookInfo() {
		try {
			BookAddLogic bookAddLogic = new BookAddLogic();
			bookAddLogic.insertBookInfo(bookBean);
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}
}
