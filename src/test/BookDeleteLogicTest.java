package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import logic.BookDeleteLogic;
import model.BookBean;

public class BookDeleteLogicTest {

	public BookBean bookBean = new BookBean();

	@Before
	public void before() {
		bookBean.setBean("test", "test", "123", "test");
	}

	@Test
	public void testInsertBookInfo() {
		try {
			BookDeleteLogic bookDeleteLogic = new BookDeleteLogic();
			bookDeleteLogic.deleteBookdb("test");
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}
}
