package com.hx.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.hx.ssm.entity.Appointment;

public interface AppointmentDao {

	/**
	 * 插入预约图书记录
	 * @param bookId
	 * @param studentId
	 * @return 插入的行数
	 */
	int insertAppointment(@Param("bookId")long bookId,@Param("studentId")long studentId);
	
	/**
	 * 图书ID和用户ID返回预约
	 * @param bookId
	 * @param stdentId
	 * @return
	 */
	Appointment queryBykeyWithBook(@Param("bookId")long bookId,@Param("studentId") long stdentId);
}
