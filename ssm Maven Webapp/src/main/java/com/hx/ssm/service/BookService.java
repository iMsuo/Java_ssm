package com.hx.ssm.service;

import java.util.List;

import com.hx.ssm.dto.AppointExecution;
import com.hx.ssm.entity.Book;

import enums.AppointStateEnum;

public interface BookService {
	/**
	 * 查询一本书
	 * @param BookId
	 * @return
	 */
	Book getById(long BookId);
	
	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> getBooks();
	
	/**
	 * 预约图书
	 * @param bookId
	 * @param studentId
	 * @return
	 */
   AppointExecution appoint(long bookId,long studentId);
	
}
