package com.masterapps.almansaj.greetingsservice.dao.repository;

import org.springframework.data.repository.CrudRepository;

import com.masterapps.almansaj.greetingsservice.dao.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByName(String name);
}
