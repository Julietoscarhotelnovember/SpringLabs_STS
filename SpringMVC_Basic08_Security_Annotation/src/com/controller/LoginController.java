package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Book;
import com.service.IBookSerivce;

@Controller
public class LoginController {
	
	@Autowired
	public IBookSerivce bookservice;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String success(ModelMap map){
		System.out.println("1. 책 추가");
		Book b1=new Book("스프링책", "kglim");
		
		//@PreAuthorize("hasRole('ROLE_WRITER')")
		bookservice.addBook(b1);
		System.out.println("추가된 책: "+b1.getName());
		
		System.out.println("2. 책 정보 가져오기");
		//@PostAuthorize("returnObject.owner==authentication.name")
		Book getbook=bookservice.getBook();
		System.out.println("getbook: "+getbook.getName());
		
		//3.책 삭제하기
		Book deletebook=new Book("오라클책", "kglim");
		//@PreAuthorize("#book.owner==authentication.name")
		bookservice.deleteBook(deletebook);
		map.addAttribute("msg", "성공적");
		
		return "success"; //view주소
	}
}
