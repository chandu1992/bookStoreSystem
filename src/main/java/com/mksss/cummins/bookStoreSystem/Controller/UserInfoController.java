package com.mksss.cummins.bookStoreSystem.Controller;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mksss.cummins.bookStoreSystem.dao.UserInfo;
import com.mksss.cummins.bookStoreSystem.entity.BookCategoryEntity;
import com.mksss.cummins.bookStoreSystem.entity.BooksEntity;
import com.mksss.cummins.bookStoreSystem.entity.UserInfoEntity;
import com.mksss.cummins.bookStoreSystem.service.CommonServices;
import com.mksss.cummins.bookStoreSystem.util.ResponseHandler;

@RestController
@RequestMapping("/user")
@CrossOrigin(allowedHeaders = "*")
public class UserInfoController {

	@Autowired
	private CommonServices commonServices;

	@CrossOrigin
	@PostMapping("/createAccount")
	public ResponseEntity<Object> createUserAccount(@RequestBody(required = true) UserInfo userData) {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			UserInfoEntity resultData = commonServices.createUserAccount(userData);

			System.out.println(resultData);
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}
	
	@CrossOrigin
	@PostMapping("/updatePassword")
	public ResponseEntity<Object> createUserAccount(
				@RequestHeader(value = "mobilenumber", required = true) String mobilenumber,
				@RequestHeader(value = "password", required = true) String password
			)  {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			String resultData = commonServices.updatePassword(mobilenumber,password);

			System.out.println(resultData);
			return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}
	
	@CrossOrigin
	@PostMapping("/checkuserIsValidOrNot")
	public ResponseEntity<Object> checkuserIsValidOrNot(
				@RequestHeader(value = "mobilenumber", required = true) String mobilenumber,
				@RequestHeader(value = "password", required = true) String password
			)  {

		try {
			System.out.println("Inside generateOfferLetter controller....");

			String resultData = commonServices.checkuserIsValidOrNot(mobilenumber,password);

			if(resultData.equals("login Sucesfully")) {
				return ResponseHandler.generateResponse(HttpStatus.OK, true, "Success", resultData);
			}else {
				return ResponseHandler.generateResponse(HttpStatus.UNAUTHORIZED, true, "Success", resultData);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e.getMessage());
		}

	}
	
	

}
