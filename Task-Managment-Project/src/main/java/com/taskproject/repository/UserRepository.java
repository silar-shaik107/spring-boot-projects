package com.taskproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskproject.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
