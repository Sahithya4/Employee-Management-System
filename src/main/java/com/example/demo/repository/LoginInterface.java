package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Login;

public interface LoginInterface extends JpaRepository<Login, String> {

}
