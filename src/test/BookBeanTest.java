//package test;
//
//import static org.hamcrest.CoreMatchers.*;
//import static org.junit.Assert.*;
//
//import javax.validation.Validation;
//import javax.validation.Validator;
//
//import org.junit.Test;
//
//import model.BookBean;
//
//public class BookBeanTest {
//
//	  static Validator validator
//      = Validation.buildDefaultValidatorFactory().getValidator();
//	@Test
//	 public void minCaseTest() throws Exception {
//	        BookBean bookBean = new BookBean();
//	        bookBean.setAuthor("a");
//	        bookBean.setBookTytle("a");
//	        bookBean.setIsbn("a");
//	        bookBean.setTotalPage("1");
//	        assertThat(validator.validate(bookBean).size(), is(0));
//	    }
//
//	@Test
//	 public void maxCaseTest() throws Exception {
//	        BookBean bookBean = new BookBean();
//	        bookBean.setAuthor("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	        bookBean.setBookTytle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//	        bookBean.setIsbn("aaaaaaaaaaaaaaaaaaaa"); //20
//	        bookBean.setTotalPage("2000");
//	        assertThat(validator.validate(bookBean).size(), is(0));
//	    }
//}
