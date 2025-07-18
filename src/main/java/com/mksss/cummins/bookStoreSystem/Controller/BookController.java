package com.mksss.cummins.bookStoreSystem.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.mksss.cummins.bookStoreSystem.exceptionHamdler.exceptions.DataNotFoundException;
import com.mksss.cummins.bookStoreSystem.exceptionHamdler.exceptions.InternalServerError;
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
	public ResponseEntity<List<BooksEntity>> myBooksCollection(

	) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BooksEntity> resultData = bookService.myBooksCollection()
					.orElseThrow(() -> new DataNotFoundException("Books collection not found"));

			ResponseHandler<List<BooksEntity>>  response= new ResponseHandler<>(resultData,200,"Reuest was successful", LocalDateTime.now());
			return new ResponseEntity(response,HttpStatus.OK);



		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/bookCategory")
	public ResponseEntity<List<BookCategoryEntity>> getBookCategory(

	) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BookCategoryEntity> resultData = bookService.getBookCategory();

			ResponseHandler<List<BookCategoryEntity>>  response= new ResponseHandler<>(resultData,200,"Reuest was successful",LocalDateTime.now());
			return new ResponseEntity(response,HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/getBooksByCategory")
	public ResponseEntity<Optional<List<BooksEntity>>> getBooksByCategory(
			@RequestHeader(value = "categoryName", required = true) String categoryName) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			Optional<List<BooksEntity>> resultData = Optional.ofNullable(bookService.getBooksByItsCategory(categoryName)
					.orElseThrow(() -> new DataNotFoundException("Category " + categoryName + "Books not found")));

			System.out.println(resultData);
			ResponseHandler<Optional<List<BooksEntity>>>  response=null;
			if(resultData.isPresent()){
				response= new ResponseHandler<>(resultData,200,"Reuest was successful",LocalDateTime.now());
			}

			return new ResponseEntity(response,HttpStatus.OK);
		} catch (InternalServerError e) {
			System.out.println(e);
			throw new InternalServerError(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/searchBookByName")
	public ResponseEntity<List<BooksEntity>> searchBookByName(
			@RequestHeader(value = "bookname", required = true) String bookname) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<BooksEntity> resultData = bookService.searchBookByName(bookname)
					.orElseThrow(() -> new DataNotFoundException(bookname+"Book not found"));


			ResponseHandler<List<BooksEntity>>  response= new ResponseHandler<>(resultData,200,"Reuest was successful",LocalDateTime.now());
			return new ResponseEntity(response,HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError(e.getMessage());
		}

	}

	@CrossOrigin
	@GetMapping("/searchBookByNameIgnorcase")
	public ResponseEntity<List<Map<String, Object>>> searchBookByNameIgnorcase(
			@RequestHeader(value = "bookname", required = true) String bookname) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			List<Map<String, Object>> resultData = bookService.searchBookByNameIgnorcase(bookname)
					.orElseThrow(() -> new DataNotFoundException(bookname+"Book not found"));

			ResponseHandler<List<Map<String, Object>>>  response= new ResponseHandler<>(resultData,200,"Reuest was successful",LocalDateTime.now());
			return new ResponseEntity(response,HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			throw new InternalServerError(e.getMessage());
		}

	}

}
