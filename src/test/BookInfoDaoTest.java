package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dao.BookInfoDao;
import model.BookBean;

public class BookInfoDaoTest {

	public BookInfoDao bookInfoDao = new BookInfoDao();
	public BookBean bookBean = new BookBean();


	@Before
	public void before() {
		try {
		bookInfoDao.newInstance();
		bookInfoDao.createDBConnection();
		bookBean.setBean("test", "test", "123", "test");
		} catch(SQLException e) {
			fail();
		}
	}

	@Test
	public void testAddBookInfo() {
		try {
			bookInfoDao.addBookInfo(bookBean, tool.SqlCostants.SQL_BOOK_ADD);
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSearchBookInfo() {
		try {
			bookInfoDao.searchBookInfo(tool.SqlCostants.SQL_BOOK_SEARCH);
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}

	@Test
	public void testDeleteBookInfo() {
		try {
			bookInfoDao.deleteBookInfo(tool.SqlCostants.SQL_BOOK_DELETE, "test");
			assertTrue(true);
		} catch (SQLException e) {
			fail();
		}
	}

	@Test
	public void testUpdateBookInfo() {
		try {
			bookInfoDao.updateBookInfo(tool.SqlCostants.SQL_UPDATE_AUTHOR, "change", "test");
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testSerchBookInfoByIsbn() {
		try {
			bookInfoDao.serchBookInfoByIsbn(tool.SqlCostants.SQL_BOOK_SEARCH_FOR_UPDATE, "test");
			assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}

	@After
	public void afterClass() {
		try {
			bookInfoDao.closeDBConnection();
		} catch (SQLException e) {
			fail();
		}
	}
}
