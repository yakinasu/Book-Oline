package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import logic.BookHomeLogic;
import model.BookBean;

public class BookHomeLogicTest {

	public BookBean bookBean = new BookBean();

	@Before
	public void before() {
	bookBean.setBean("test", "test", "123", "test");
	//add SQL

	}

	@Test
	public void testInsertBookInfo() {
		try {
			BookHomeLogic bookHomeLogic = new BookHomeLogic();
			bookHomeLogic.searchBookdb();
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}

}
