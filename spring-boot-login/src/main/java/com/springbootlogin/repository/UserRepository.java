package com.springbootlogin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springbootlogin.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Serializable> {

	User findByUsername(String username);
}
