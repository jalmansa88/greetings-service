package com.masterapps.almansaj.greetingsservice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masterapps.almansaj.greetingsservice.dao.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
