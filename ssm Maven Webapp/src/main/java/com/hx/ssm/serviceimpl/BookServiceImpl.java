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
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 */
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			int update=bookDao.reduceNumber(bookId);
			if(update <=0)
			{
				//库存不足
				throw new NoNumberException("NoNUmber");
			}
			else {
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0)
				{
					//重复预约
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
			// 所有编译期异常转换为运行期异常
			//return new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);//错误写法
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

	
}
