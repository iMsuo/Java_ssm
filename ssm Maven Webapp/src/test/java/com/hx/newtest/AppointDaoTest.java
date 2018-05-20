package com.hx.newtest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hx.ssm.dao.AppointmentDao;
import com.hx.ssm.entity.Appointment;

public class AppointDaoTest extends BaseTest {

	@Autowired
	AppointmentDao  appointmentDao;
	
	@Test
	public void testInsertAppoint()
	{
		int id=appointmentDao.insertAppointment(1000,1);
		System.out.println(id);
	}
	
	@Test
	public void testQueryAppoint()
	{
		Appointment appointment=appointmentDao.queryBykeyWithBook(1000, 1);
		System.out.println(appointment.getBookId()+"-"+appointment.getBook().getBookId());
	}
}
