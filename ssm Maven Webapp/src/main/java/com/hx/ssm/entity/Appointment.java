package com.hx.ssm.entity;

import java.sql.Date;

public class Appointment {
	private long bookId;
	private long studentId;
	private Date appointTime;
	private Book book;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Date getAppointTime() {
		return appointTime;
	}
	public void setAppointTimeDate(Date appointTimeDate) {
		this.appointTime = appointTimeDate;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	
}
