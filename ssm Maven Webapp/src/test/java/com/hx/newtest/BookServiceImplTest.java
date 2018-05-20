package com.hx.newtest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hx.ssm.dto.AppointExecution;
import com.hx.ssm.service.BookService;

public class BookServiceImplTest extends BaseTest {
	
	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception
	{
		AppointExecution  appointExecution=bookService.appoint(1001,1);
		System.out.println(appointExecution);
	}
	
}
