package com.employee_management.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Employee;
import com.employee_management.entity.Leaves;

@EnableAutoConfiguration
@Service
public class AddLeavesrepository {

	@Autowired
	Employee_Interface employee_interface;

	@Autowired
	Leave_Interface leaveInterface;

	// This method is used to find employee in employee table from database
	public Employee findRepository(Employee employee, String employeename) {

		Employee employee1 = employee_interface.getEmployee(employeename);
		return employee1;
	}

	// This method is used to find leave in Leaves table from database
	public Leaves findcancelRepository(Leaves leave, String name) {

		Leaves leaves = leaveInterface.getleaves(name);
		return leaves;

	}

	// This method is used to add leave in leave table from database
	public String addRepository(Leaves leave) {

		leaveInterface.save(leave);
		return "Successfully added";
	}

	// This method is used to accept leave in leave table from database
	public String acceptLeavesRepository(Leaves leave) {
		Leaves leaves = leaveInterface.findById(leave.getLeaveid()).get();
		leaves.setStatus("accepted");
		leaveInterface.save(leaves);
		return "accepted";
	}

	// This method is used to reject leave in leave table from database
	public String rejectLeavesRepository(Leaves leave) {
		Leaves leaves = leaveInterface.findById(leave.getLeaveid()).get();
		leaves.setStatus("rejected");
		leaveInterface.save(leaves);
		return "rejected";
	}

	// This method is used to cancel leave in leave table from database
	public String cancelLeavesRepository(Leaves leave) {
		Leaves leaves = leaveInterface.findById(leave.getLeaveid()).get();
		leaveInterface.delete(leaves);
		return "canceled";
	}

	// This method is used to find leave status from leave table
	public String statusLeavesRepository(Leaves leave) {
		Leaves leaves = leaveInterface.findById(leave.getLeaveid()).get();
		return leaves.getStatus();
	}

}
