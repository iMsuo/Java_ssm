package com.hx.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hx.ssm.entity.Book;

public interface BookDao {
	
	/**
	 * 通过ID查询图书
	 * @param id
	 * @return
	 */
	Book queryById(long id);
	
	/**
	 * 查询所有图书
	 * 使用param的原因是参数大于1个是mybastic无法识别
	 * @param 起始位置
	 * @param 查询条数
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	
	/**
	 * 减少馆存数量
	 * @param bookId
	 * @return 更新的记录数
	 */
	int reduceNumber(long bookId);
}
