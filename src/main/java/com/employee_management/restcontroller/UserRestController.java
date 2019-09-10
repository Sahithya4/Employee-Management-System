package com.employee_management.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.entity.Employee;
import com.employee_management.entity.Leaves;
import com.employee_management.repository.AddLeavesrepository;
import com.employee_management.repository.ViewLeavesRepository;

@RestController
@RequestMapping("user")
public class UserRestController {

	@Autowired
	AddLeavesrepository ls;

	// This method gets data from UserController to find a employee and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/find/{employeename}", method = RequestMethod.POST)
	public Employee add(@RequestBody Employee employee, @PathVariable("employeename") String employeename) {
		Employee status = ls.findRepository(employee, employeename);
		return status;
	}

	// This method gets data from UserController to add a leave and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody Leaves leave) {

		String status = ls.addRepository(leave);
		return status;
	}

	// This method gets data from UserController to accept a leave and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public String acceptLeaves(@RequestBody Leaves leave) {

		String status = ls.acceptLeavesRepository(leave);
		return status;
	}

	// This method gets data from UserController to reject a leave and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/reject", method = RequestMethod.POST)
	public String rejectLeaves(@RequestBody Leaves leave) {

		String status = ls.rejectLeavesRepository(leave);
		return status;
	}

	// This method gets data from UserController to find a leave and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/cancel/{name}", method = RequestMethod.POST)
	public Leaves cancelLeaves(@RequestBody Leaves leave, @PathVariable("name") String name) {

		Leaves status = ls.findcancelRepository(leave, name);
		return status;
	}

	// This method gets data from UserController to cancel a leave and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String cancelleaves(@RequestBody Leaves leave) {

		String status = ls.cancelLeavesRepository(leave);
		return status;
	}

	// This method gets data from UserController to find status of leave and these
	// rest calls are sent to service method.
	@RequestMapping(value = "/status", method = RequestMethod.POST)
	public String statusleaves(@RequestBody Leaves leave) {

		String status = ls.statusLeavesRepository(leave);
		return status;
	}

	@Autowired
	ViewLeavesRepository viewleaves;

	// This method gets data from UserController to view leaves and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/viewleaves/{eachemployee}", method = RequestMethod.GET)
	public Leaves viewLeaves(@PathVariable("eachemployee") String eachemployee) {
		Leaves status = viewleaves.viewLeavesRepository(eachemployee);
		return status;
	}

}
