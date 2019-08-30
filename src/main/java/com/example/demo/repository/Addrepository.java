package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;

@EnableAutoConfiguration
@Service
public class Addrepository {

	@Autowired
	Admin_Interface admin_interface;

	@Autowired
	LoginInterface loginrepository;
	//This method is used to add employee in employee table from database
	public Employee addRepository(Employee employee) {
		admin_interface.save(employee);
		return employee;
	}
	//This method is used to add employee in login table from database
	public String addRepository(Login login) {
		loginrepository.save(login);
		return "Successfully added";
	}

}
