package tdunglas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ObjectMApperTest {
	
	public Author author;
	public Book book;
	public ObjectMApper om;
	
	@Before
	public void init(){
		author = new Author("nomA","prenomA");
		book = new Book("title book", "filling book chapter is not written", author);
		om = new ObjectMApper();
	}
	
	@Test
	public void test_with_int(){
		// given 
		// when 
		String res = om.objectToJSON(123);
		
		// then
		assertEquals("123" , res);
	}
	
	@Test
	public void test_with_String(){
		// given 
		// when 
		String res = om.objectToJSON("HOY");
		
		// then
		assertEquals("\"HOY\"" , res);
	}
	
	@Test
	public void test_with_boolean(){
		// given 
		// when 
		String res_t1 = om.objectToJSON(true);
		String res_t2 = om.objectToJSON(Boolean.TRUE);
		
		String res_f1 = om.objectToJSON(false);
		String res_f2 = om.objectToJSON(Boolean.FALSE);
		
		// then
		assertEquals("true" , res_t1);
		assertEquals("true" , res_t2);
		
		assertEquals("false" , res_f1);
		assertEquals("false" , res_f2);
	}
	
	@Test
	public void testBookInJSON(){
		// given 
		String wish = "{\"Book\":[\"title\":\"title book\",\"contenu\":\"filling book chapter is not written\",\"author\":{\"Author\":[\"firstName\":\"nomA\",\"lastName\":\"prenomA\"]}]}";
		
		// when 
		String res = om.objectToJSON(book);
		
		// then
		assertEquals(wish , res);
	}

}
