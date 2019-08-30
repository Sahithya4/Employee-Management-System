package com.example.demo.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Login;
import com.example.demo.repository.Addrepository;
import com.example.demo.repository.DeleteRepository;
import com.example.demo.repository.ListSalarybetween;
import com.example.demo.repository.ListbyManager;
import com.example.demo.repository.ViewemployeeRepository;

@RestController
@RequestMapping("admin")
public class AdminRestController {

	@Autowired
	Addrepository ls;

	// This method gets data from AdminController to add a employee into employee
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Employee add(@RequestBody Employee employee) {

		Employee status = ls.addRepository(employee);
		return status;
	}

	// This method gets data from AdminController to add a employee into login table
	// and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/addlogin", method = RequestMethod.POST)
	public String add(@RequestBody Login login) {

		String status = ls.addRepository(login);
		return status;
	}

	@Autowired
	DeleteRepository ds;

	// This method gets data from AdminController to delete a employee from employee
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody Employee employee) {

		String status = ds.deleteRepository(employee);
		return status;
	}

	// This method gets data from AdminController to delete a employee from login
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/deletelogin", method = RequestMethod.POST)
	public String deletelogin(@RequestBody Login login) {
		String status = ds.deleteRepository(login);
		return status;
	}

	// This method gets data from AdminController to find a employee in employee
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public Employee find(@RequestBody Employee employee) {
		Employee status = ds.findRepository(employee);
		return status;
	}

	@Autowired
	ViewemployeeRepository es;

	// This method gets data from AdminController to view employees from employee
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/viewemployees", method = RequestMethod.GET)
	public ArrayList<Employee> getEmployees() {
		return es.viewEmployeeRepository();
	}

	// This method gets data from AdminController to calculate pf of each employee
	// and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/calculatingpf", method = RequestMethod.GET)
	public ArrayList<Employee> calculatingpf() {
		return es.viewEmployeeRepository();
	}

	// This method gets data from AdminController to view departments from employee
	// table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/viewdepartments", method = RequestMethod.GET)
	public ArrayList<Employee> getDepartments() {
		return es.viewEmployeeRepository();
	}

	@Autowired
	ListbyManager lm;

	// This method gets data from AdminController to view list of employees
	// reporting to specific manager from employee table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/listbymanager/{reportingmanager}", method = RequestMethod.GET)
	public ArrayList<String> getlistbyManager(@PathVariable("reportingmanager") String reportingmanager) {
		return lm.listByManagerRepository(reportingmanager);
	}

	@Autowired
	ListSalarybetween lsb;

	// This method gets data from AdminController to view employees whose salary is
	// between 10000 to 20000 from employee table and these rest calls
	// are sent to service method.
	@RequestMapping(value = "/salarybetween", method = RequestMethod.GET)
	public ArrayList<Employee> getSalarybetween() {
		return lsb.listSalaryBetween();
	}
}
