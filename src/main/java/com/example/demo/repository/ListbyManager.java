package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@EnableAutoConfiguration
@Service
public class ListbyManager {

	@Autowired
	Employee_Interface employee_interface;

	// This method is used to view list of employees reporting to specific manager
	// from database
	public ArrayList<String> listByManagerRepository(String reportingmanager) {
		ArrayList<String> list = employee_interface.getReportingmanagers(reportingmanager);
		return list;
	}

}
