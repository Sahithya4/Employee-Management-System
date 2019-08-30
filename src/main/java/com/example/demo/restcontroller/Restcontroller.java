package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Login;
import com.example.demo.repository.Loginrepository;

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
