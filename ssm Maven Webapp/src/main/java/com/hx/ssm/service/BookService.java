package com.hx.ssm.service;

import java.util.List;

import com.hx.ssm.dto.AppointExecution;
import com.hx.ssm.entity.Book;

import enums.AppointStateEnum;

public interface BookService {
	/**
	 * ��ѯһ����
	 * @param BookId
	 * @return
	 */
	Book getById(long BookId);
	
	/**
	 * ��ѯ����ͼ��
	 * @return
	 */
	List<Book> getBooks();
	
	/**
	 * ԤԼͼ��
	 * @param bookId
	 * @param studentId
	 * @return
	 */
   AppointExecution appoint(long bookId,long studentId);
	
}
