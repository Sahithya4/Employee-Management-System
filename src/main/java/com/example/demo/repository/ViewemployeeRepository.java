package com.example.demo.repository;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

@EnableAutoConfiguration
@Service

public class ViewemployeeRepository {

	@Autowired
	Admin_Interface admin_interface;
	//This method is used to view employees from database
	public ArrayList<Employee> viewEmployeeRepository() {
		return (ArrayList<Employee>) admin_interface.findAll();
	}

}
