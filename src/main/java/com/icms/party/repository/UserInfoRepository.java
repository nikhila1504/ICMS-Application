package com.icms.party.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.icms.party.entity.User;

public interface UserInfoRepository extends CrudRepository<User, Integer>{

	User findByEmail(String email);
	

}
