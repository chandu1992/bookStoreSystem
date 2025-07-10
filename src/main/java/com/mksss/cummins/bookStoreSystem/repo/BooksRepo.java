package com.mksss.cummins.bookStoreSystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;

public interface BooksRepo extends JpaRepository<BooksEntity, String> {

	@Query(nativeQuery = true, value = "select * from bookStoreSystem.books_tbl where category=:categoryName")
	List<BooksEntity> findByItsCategory(String categoryName);

	List<BooksEntity> findByBookNameLike(String bookname);

//	@Query("select book_name from bookStoreSystem.books_tbl b where lower(b.bookName) like lower(concat('%', :nameToFind, '%'))")
//	List<BooksEntity> findByBooknameIgnorcase(@Param("nameToFind") String bookname);

//	@Query("FROM bookStoreSystem.books_tbl WHERE UPPER(bookname) LIKE CONCAT('%',UPPER(?1),'%')")
//	List<BooksEntity> findBookByName(String bookname);

}
