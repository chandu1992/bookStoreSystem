package com.mksss.cummins.bookStoreSystem.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;

public interface BookInfoService {

	List<BooksEntity> myBooksCollection();

	List<BookCategoryEntity> getBookCategory();
	
	List<BooksEntity> getBooksByItsCategory(String categoryName);
	
	List<BooksEntity> searchBookByName(String bookname);
	
	 List<Map<String, Object>> searchBookByNameIgnorcase(String bookname);
}
