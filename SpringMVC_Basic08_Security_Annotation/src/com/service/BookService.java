package com.service;

import com.bean.Book;

public class BookService implements IBookSerivce {

	@Override
	public void addBook(Book book) {
		System.out.println("책 추가 성공");
	}

	@Override
	public Book getBook() {
		Book book=new Book("자바책", "kglim");
		return book;
	}

	@Override
	public void deleteBook(Book book) {
		System.out.println("책 삭제 성공");
	}

}
