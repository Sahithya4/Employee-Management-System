package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;

@EnableAutoConfiguration
@Service

public class DeleteRepository{

	@Autowired
	Admin_Interface admin_interface;

	@Autowired
	LoginInterface loginrepository;

	//This method is used to delete employee in employee table from database
	public String deleteRepository(Employee employee) {

		admin_interface.delete(employee);
		return "Deleted Successfully";
	}
	//This method is used to delete employee in login table from database
	public String deleteRepository(Login login) {

		loginrepository.deleteById(login.getName());
		return "Deleted Successfully";
	}
	//This method is used to find employee from database
	public Employee findRepository(Employee employee) {

		Employee employee1 = admin_interface.findById(employee.getEmployeeid()).get();
		return employee1;
	}

}
