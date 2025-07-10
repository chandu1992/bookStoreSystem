package com.mksss.cummins.bookStoreSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;

public interface BookCategoryRepo extends JpaRepository<BookCategoryEntity, Integer>{

	
}
