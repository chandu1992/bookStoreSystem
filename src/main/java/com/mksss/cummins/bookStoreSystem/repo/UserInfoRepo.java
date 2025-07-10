package com.mksss.cummins.bookStoreSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mksss.cummins.bookStoreSystem.entity.UserInfoEntity;

public interface UserInfoRepo extends JpaRepository<UserInfoEntity, String>{

}
