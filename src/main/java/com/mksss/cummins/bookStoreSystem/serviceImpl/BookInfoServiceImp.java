package com.mksss.cummins.bookStoreSystem.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
	public Optional<List<BooksEntity>> myBooksCollection() {
		
		return Optional.of(booksRepo.findAll());
	}

	@Override
	public List<BookCategoryEntity> getBookCategory() {
		
		return bookCategoryRepo.findAll();
	}

	@Override
	public Optional<List<BooksEntity>> getBooksByItsCategory(String categoryName) {


		List<BooksEntity> books = booksRepo.findByItsCategory(categoryName);

		return books.isEmpty() ? Optional.empty() : Optional.of(books);
	}

	@Override
	public Optional<List<BooksEntity>> searchBookByName(String bookname) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(booksRepo.findByBookNameLike(bookname));
	}

	@Override
	public  Optional<List<Map<String, Object>>> searchBookByNameIgnorcase(String bookname) {
		// TODO Auto-generated method stub
		
		String query = "select * from books_tbl where book_name Like '%"+bookname+"%'";
		
		
		 List<Map<String, Object>> books = temp.queryForList(query);
//		 return Optional.of(books);
		return null;
	}
}
