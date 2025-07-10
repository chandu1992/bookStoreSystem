package com.mksss.cummins.bookStoreSystem.service;

import java.util.List;
import java.util.Map;

import com.mksss.cummins.bookStoreSystem.dao.UserInfo;
import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;
import com.mksss.cummins.bookStoreSystem.entity.UserInfoEntity;

public interface CommonServices {

	UserInfoEntity createUserAccount(UserInfo userDataInfo);

	String updatePassword(String mobilenumber, String password);

	String checkuserIsValidOrNot(String mobilenumber, String password);

	
	
	

}
