package com.hx.ssm.web;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hx.ssm.dto.AppointExecution;
import com.hx.ssm.dto.Result;
import com.hx.ssm.entity.Book;
import com.hx.ssm.service.BookService;

import enums.AppointStateEnum;
import exception.NoNumberException;
import exception.RepeatAppointException;

@Controller
@RequestMapping("/book")
public class BookController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	private String list(Model model)
	{
		System.out.println("123");
		List<Book> list=bookService.getBooks();
		model.addAttribute("list",list);
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/{bookId}/detail", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId,Model model)
	{
		if (bookId == null) {
			return "redirect:/book/list";
		}
		Book book = bookService.getById(bookId);
		if (book == null) {
			return "forward:/book/list";
		}
		model.addAttribute("book", book);
		return "detail";
	}
	
	
	   //ajax json
		@RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST, produces = {
				"application/json; charset=utf-8" })
		@ResponseBody
		private Result<AppointExecution> appoint(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId) {
			System.out.println("111");
			if (studentId == null || studentId.equals("")) {
				System.out.println("111");
				return new Result<AppointExecution>(false, "学号不能为空");
			}
			//AppointExecution execution = bookService.appoint(bookId, studentId);//错误写法，不能统一返回，要处理异常（失败）情况
			AppointExecution execution = null;
			try {
				execution = bookService.appoint(bookId, studentId);
			} catch (NoNumberException e1) {
				execution = new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
			} catch (RepeatAppointException e2) {
				execution = new AppointExecution(bookId, AppointStateEnum.REPEAT_APPOINT);
			} catch (Exception e) {
				execution = new AppointExecution(bookId, AppointStateEnum.INNER_ERROR);
			}
			return new Result<AppointExecution>(true, execution);
		}
}
