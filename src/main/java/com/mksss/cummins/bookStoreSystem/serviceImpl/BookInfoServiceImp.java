package com.mksss.cummins.bookStoreSystem.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;
import com.mksss.cummins.bookStoreSystem.repo.BookCategoryRepo;
import com.mksss.cummins.bookStoreSystem.repo.BooksRepo;
import com.mksss.cummins.bookStoreSystem.service.BookInfoService;

@Service
public class BookInfoServiceImp implements BookInfoService {

	@Autowired
	private BooksRepo booksRepo;
	
	@Autowired
	private BookCategoryRepo bookCategoryRepo;
	
	@Autowired
	JdbcTemplate temp ;
	
	@Override
	public List<BooksEntity> myBooksCollection() {
		
		return booksRepo.findAll();
	}

	@Override
	public List<BookCategoryEntity> getBookCategory() {
		
		return bookCategoryRepo.findAll();
	}

	@Override
	public List<BooksEntity> getBooksByItsCategory(String categoryName) {
		
		
		return booksRepo.findByItsCategory(categoryName);
	}

	@Override
	public List<BooksEntity> searchBookByName(String bookname) {
		// TODO Auto-generated method stub
		return booksRepo.findByBookNameLike(bookname);
	}

	@Override
	public  List<Map<String, Object>> searchBookByNameIgnorcase(String bookname) {
		// TODO Auto-generated method stub
		
		String query = "select * from books_tbl where book_name Like '%"+bookname+"%'";
		
		
		 List<Map<String, Object>> books = temp.queryForList(query);
		 return books;
		
//		return booksRepo.findByBooknameIgnorcase(bookname);
	}
}
