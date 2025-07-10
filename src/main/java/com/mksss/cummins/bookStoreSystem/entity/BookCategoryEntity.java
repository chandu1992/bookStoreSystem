package com.mksss.cummins.bookStoreSystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_category_tbl")
public class BookCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
