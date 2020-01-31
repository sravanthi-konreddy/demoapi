package com.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.BookDAO;
import com.demo.model.Book;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDAO bookdao;

	@Override
	public long save(Book book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Book get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Book> list() {
		 return bookdao.list();
	}

	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
