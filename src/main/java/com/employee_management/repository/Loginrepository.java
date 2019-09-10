package com.employee_management.repository;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.employee_management.entity.Login;

@EnableAutoConfiguration
@Service

public class Loginrepository {

	@Autowired
	LoginInterface loginrepository;

	// This method is used to validate user from login table
	public String loginRepository(Login login) {
		ArrayList<Login> list1 = (ArrayList<Login>) loginrepository.findAll();
		String status = null;
		for (int i = 0; i < list1.size(); i++) {
			Login list = list1.get(i);
			if (list.getName().equals(login.getName()) && list.getPassword().equals(login.getPassword())
					&& list.getRole().equals("admin")) {
				status = "admin";
				break;
			} else if (list.getName().equals(login.getName()) && list.getPassword().equals(login.getPassword())
					&& list.getRole().equals("user")) {
				status = "user";
				break;
			} else
				status = "Wrong Credentials";
		}
		return status;

	}

	// This method is used to generate random password for a particular employee
	public static String generatePassword() {
		int n = 9;
		String x;
		final Random RANDOM = new Random();
		String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String splchar = "@!#$%&*?+-";
		StringBuilder returnValue = new StringBuilder(n);
		for (int i = 0; i < 4; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
		returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
		returnValue.append(digits.charAt(RANDOM.nextInt(digits.length())));
		returnValue.append(splchar.charAt(RANDOM.nextInt(splchar.length())));
		x = returnValue.toString();
		return x;
	}
}
