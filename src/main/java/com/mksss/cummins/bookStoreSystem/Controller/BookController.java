package com.mksss.cummins.bookStoreSystem.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;
import com.mksss.cummins.bookStoreSystem.service.BookInfoService;
import com.mksss.cummins.bookStoreSystem.util.ResponseHandler;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookInfoService bookService;

	@CrossOrigin
	@GetMapping("/myBooksCollection")
	public ResponseEntity<Object> myBooksCollection(

	) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BooksEntity> resultData = bookService.myBooksCollection();

			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/bookCategory")
	public ResponseEntity<Object> getBookCategory(

	) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BookCategoryEntity> resultData = bookService.getBookCategory();

			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/getBooksByCategory")
	public ResponseEntity<Object> getBooksByCategory(
			@RequestHeader(value = "categoryName", required = true) String categoryName) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BooksEntity> resultData = bookService.getBooksByItsCategory(categoryName);

			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/searchBookByName")
	public ResponseEntity<Object> searchBookByName(
			@RequestHeader(value = "bookname", required = true) String bookname) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BooksEntity> resultData = bookService.searchBookByName(bookname);

			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/searchBookByNameIgnorcase")
	public ResponseEntity<Object> searchBookByNameIgnorcase(
			@RequestHeader(value = "bookname", required = true) String bookname) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<Map<String, Object>> resultData = bookService.searchBookByNameIgnorcase(bookname);

			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);

		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}

}
