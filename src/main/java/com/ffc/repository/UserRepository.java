package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffc.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
