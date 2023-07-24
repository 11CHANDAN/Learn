package com.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.code.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
