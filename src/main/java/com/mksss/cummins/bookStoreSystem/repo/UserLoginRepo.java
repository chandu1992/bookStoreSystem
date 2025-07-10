package com.mksss.cummins.bookStoreSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mksss.cummins.bookStoreSystem.entity.UserLoginEntity;

public interface UserLoginRepo extends JpaRepository<UserLoginEntity, String> {

	UserLoginEntity getByMobilenumber(String mobilenumber);

}
