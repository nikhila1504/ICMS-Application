package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.User;

@Repository
public interface UserInfoRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
