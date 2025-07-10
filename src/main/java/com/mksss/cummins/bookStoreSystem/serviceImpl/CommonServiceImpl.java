package com.mksss.cummins.bookStoreSystem.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mksss.cummins.bookStoreSystem.dao.UserInfo;
import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;
import com.mksss.cummins.bookStoreSystem.entity.UserInfoEntity;
import com.mksss.cummins.bookStoreSystem.entity.UserLoginEntity;
import com.mksss.cummins.bookStoreSystem.repo.UserInfoRepo;
import com.mksss.cummins.bookStoreSystem.repo.UserLoginRepo;
import com.mksss.cummins.bookStoreSystem.repo.BookCategoryRepo;
import com.mksss.cummins.bookStoreSystem.repo.BooksRepo;
import com.mksss.cummins.bookStoreSystem.service.CommonServices;

@Service
public class CommonServiceImpl implements CommonServices {

	@Autowired
	private UserInfoRepo userInfoRepo;
	
	@Autowired
	private UserLoginRepo userLoginRepo;
	
	@Override
	public UserInfoEntity createUserAccount(UserInfo userDataInfo) {
		// TODO Auto-generated method stub
		
		
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		
		userInfoEntity.setFirstName(userDataInfo.getFirstName());
		userInfoEntity.setLastname(userDataInfo.getLastname());
		userInfoEntity.setMobileNumber(userDataInfo.getMobileNumber());
		userInfoEntity.setBirthDate(userDataInfo.getBirthDate());
		userInfoEntity.setGender(userDataInfo.getGender());
		
		userInfoRepo.save(userInfoEntity);
		
		UserLoginEntity userLoginEntity = new UserLoginEntity();
		userLoginEntity.setMobilenumber(userDataInfo.getMobileNumber());
		userLoginEntity.setPassword(userDataInfo.getPassword());
		
		userLoginRepo.save(userLoginEntity);
		
		
		
		
		return userInfoEntity;
	}

	@Override
	public String updatePassword(String mobilenumber, String password) {
		// TODO Auto-generated method stub
		try {
			
			UserLoginEntity userPresent = userLoginRepo.getByMobilenumber(mobilenumber);
			
			if(userPresent!=null) {
				UserLoginEntity userLoginEntity = new UserLoginEntity();
				userLoginEntity.setMobilenumber(mobilenumber);
				userLoginEntity.setPassword(password);
				userLoginRepo.save(userLoginEntity);
				return "password updated successfully";
			}else {
				return "Please enter correct mobile number or email id";
			}
			
		}catch(Exception e) {
			return "Somethning went wrong";
		}
		
	}

	@Override
	public String checkuserIsValidOrNot(String mobilenumber, String password) {

try {
			
			UserLoginEntity userPresent = userLoginRepo.getByMobilenumber(mobilenumber);
			
			if(userPresent!=null) {
				return "login Sucesfully";
			}else {
				return "unauthorized user";
			}
			
		}catch(Exception e) {
			return "Somethning went wrong";
		}
	}

	

}
