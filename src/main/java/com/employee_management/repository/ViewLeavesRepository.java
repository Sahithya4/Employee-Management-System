package com.employee_management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Leaves;

@EnableAutoConfiguration
@Service
public class ViewLeavesRepository {

	@Autowired
	Leave_Interface leaveInterface;

	// This method is used to view leaves from leave table from database
	public Leaves viewLeavesRepository(String eachemployee) {
		Leaves leave = leaveInterface.getleaves(eachemployee);
		return leave;
	}
}
