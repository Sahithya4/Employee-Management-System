package com.employee_management.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Employee;

@EnableAutoConfiguration
@Service
public class ListSalarybetween {

	@Autowired
	Employee_Interface employee_interface;

	// This method is used to view employees whose salary range between 10000 to
	// 20000 from database
	public ArrayList<Employee> listSalaryBetween() {
		return employee_interface.getSalarybetween();
	}

}
