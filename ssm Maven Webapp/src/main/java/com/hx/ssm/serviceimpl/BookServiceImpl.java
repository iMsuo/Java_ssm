package com.hx.ssm.serviceimpl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hx.ssm.dao.AppointmentDao;
import com.hx.ssm.dao.BookDao;
import com.hx.ssm.dto.AppointExecution;
import com.hx.ssm.entity.Appointment;
import com.hx.ssm.entity.Book;
import com.hx.ssm.service.BookService;

import enums.AppointStateEnum;
import exception.AppointException;
import exception.NoNumberException;
import exception.RepeatAppointException;

@Service
public class BookServiceImpl implements BookService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	
	public Book getById(long BookId) {
		return bookDao.queryById(BookId);
	}

	public List<Book> getBooks() {
		return bookDao.queryAll(0, 100);
	}

	@Transactional
	/**
	 * ʹ��ע��������񷽷����ŵ㣺 1.�����ŶӴ��һ��Լ������ȷ��ע���񷽷��ı�̷��
	 * 2.��֤���񷽷���ִ��ʱ�価���̣ܶ���Ҫ�����������������RPC/HTTP������߰��뵽���񷽷��ⲿ
	 * 3.�������еķ�������Ҫ������ֻ��һ���޸Ĳ�����ֻ����������Ҫ�������
	 */
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			int update=bookDao.reduceNumber(bookId);
			if(update <=0)
			{
				//��治��
				throw new NoNumberException("NoNUmber");
			}
			else {
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0)
				{
					//�ظ�ԤԼ
					throw new RepeatAppointException("Repeate");
				}
				else {
					Appointment appointment=appointmentDao.queryBykeyWithBook(bookId, studentId);
					return new AppointExecution(bookId, AppointStateEnum.SUCCESS,appointment);
				}
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// ���б������쳣ת��Ϊ�������쳣
			//return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//����д��
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

	
}
