package com.employee_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee_management.entity.Login;

public interface LoginInterface extends JpaRepository<Login, String> {

}
