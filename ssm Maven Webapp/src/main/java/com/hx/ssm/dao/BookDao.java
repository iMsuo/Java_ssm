package com.hx.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hx.ssm.entity.Book;

public interface BookDao {
	
	/**
	 * ͨ��ID��ѯͼ��
	 * @param id
	 * @return
	 */
	Book queryById(long id);
	
	/**
	 * ��ѯ����ͼ��
	 * ʹ��param��ԭ���ǲ�������1����mybastic�޷�ʶ��
	 * @param ��ʼλ��
	 * @param ��ѯ����
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	/**
	 * ���ٹݴ�����
	 * @param bookId
	 * @return ���µļ�¼��
	 */
	int reduceNumber(long bookId);
}
