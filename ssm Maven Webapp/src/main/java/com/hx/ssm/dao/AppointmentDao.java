package com.hx.ssm.dao;

import org.apache.ibatis.annotations.Param;

import com.hx.ssm.entity.Appointment;

public interface AppointmentDao {

	/**
	 * ����ԤԼͼ���¼
	 * @param bookId
	 * @param studentId
	 * @return ���������
	 */
	int insertAppointment(@Param("bookId")long bookId,@Param("studentId")long studentId);
	
	/**
	 * ͼ��ID���û�ID����ԤԼ
	 * @param bookId
	 * @param stdentId
	 * @return
	 */
	Appointment queryBykeyWithBook(@Param("bookId")long bookId,@Param("studentId") long stdentId);
}
