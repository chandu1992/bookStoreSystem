package com.mksss.cummins.bookStoreSystem.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;

public interface BookInfoService {

	Optional<List<BooksEntity>> myBooksCollection();

	List<BookCategoryEntity> getBookCategory();

	Optional<List<BooksEntity>> getBooksByItsCategory(String categoryName);

	Optional<List<BooksEntity>> searchBookByName(String bookname);
	
	 Optional<List<Map<String, Object>>> searchBookByNameIgnorcase(String bookname);
}
