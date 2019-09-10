package com.employee_management.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee_management.entity.Login;
import com.employee_management.repository.Loginrepository;

@RestController
@RequestMapping("valid")
public class Restcontroller {

	@Autowired
	Loginrepository loginrepository;

	// This method gets data from LoginController to validate a user and these rest
	// calls are sent to service method.
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestBody Login login) {
		String status = loginrepository.loginRepository(login);
		return status;
	}

}
