package com.hx.ssm.dto;

import com.hx.ssm.entity.Appointment;

import enums.AppointStateEnum;

public class AppointExecution {
	/**
	 * 秒杀
	 */
	private long bookId;
	private int state;//预约结果状态
	private String stateInfo;//状态标志
	private Appointment appointment;
	
	public AppointExecution()
	{}
	
	// 预约失败的构造器
		public AppointExecution(long bookId, AppointStateEnum stateEnum) {
			this.bookId = bookId;
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
		}

		// 预约成功的构造器
		public AppointExecution(long bookId, AppointStateEnum stateEnum, Appointment appointment) {
			this.bookId = bookId;
			this.state = stateEnum.getState();
			this.stateInfo = stateEnum.getStateInfo();
			this.appointment = appointment;
		}

		public long getBookId() {
			return bookId;
		}

		public void setBookId(long bookId) {
			this.bookId = bookId;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public String getStateInfo() {
			return stateInfo;
		}

		public void setStateInfo(String stateInfo) {
			this.stateInfo = stateInfo;
		}

		public Appointment getAppointment() {
			return appointment;
		}

		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}
		
		
		
		
	
}
