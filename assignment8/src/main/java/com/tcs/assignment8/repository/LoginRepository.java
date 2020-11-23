package com.tcs.assignment8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.assignment8.model.Login;
@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
