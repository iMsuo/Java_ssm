package com.hx.newtest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hx.ssm.dao.BookDao;
import com.hx.ssm.entity.Book;

public class BookDaoTest extends BaseTest {
	
	@Autowired
	private BookDao bookDao;
	
	@Test
	public void testQueryById()
	{
		long bookId=1000;
		Book book=bookDao.queryById(bookId);
		System.out.println(book.getName());
	}

	@Test
	public void testQueryAll()
	{
		ArrayList<Book> books=(ArrayList<Book>) bookDao.queryAll(0, 2);
		for(Book book:books)
		{
			System.out.println(book.getBookId()+":"+book.getName());
		}
	}
	
	@Test
	public void testReduceNum()
	{
		int id=bookDao.reduceNumber(1000);
		System.out.println(id);
	}
}
