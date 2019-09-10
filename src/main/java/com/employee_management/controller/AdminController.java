package com.employee_management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.employee_management.entity.Employee;
import com.employee_management.entity.Login;
import com.employee_management.repository.Loginrepository;

@Controller
public class AdminController {

	// This Method is called from the AdminOperations.jsp page and this method is
	// used to add employee to database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addcontroller(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee employee = new Employee();
		Login login = new Login();
		String salarys = request.getParameter("salary");
		float salary = Float.parseFloat(salarys);
		employee.setEmployeename(request.getParameter("name"));
		employee.setEmail(request.getParameter("email"));
		employee.setDepartmentname(request.getParameter("deptname"));
		employee.setReportingmanager(request.getParameter("repmanager"));
		employee.setSalary(salary);
		login.setName(request.getParameter("name"));
		String password = Loginrepository.generatePassword();
		login.setPassword(password);
		login.setRole("user");
		String url = "http://localhost:8082/admin/add"; // Adding into Employee table
		RestTemplate restTemplate = new RestTemplate();
		Employee employ = restTemplate.postForObject(url, employee, Employee.class);
		login.setEmployee(employ);
		String url1 = "http://localhost:8082/admin/addlogin"; // Adding into login table
		restTemplate.postForObject(url1, login, String.class);
		return "redirect:AdminOperations.jsp";
	}

	// This Method is called from the AdminOperations.jsp page and this method is
	// used to delete employee to database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletecontroller(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee employee = new Employee();
		Login login = new Login();
		String id = request.getParameter("id");
		int employeeid = Integer.parseInt(id);
		employee.setEmployeeid(employeeid);
		String url = "http://localhost:8082/admin/find";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Employee> employResponse = restTemplate.postForEntity(url, employee, Employee.class);
		Employee employ = employResponse.getBody();
		login.setEmployee(employ);
		login.setName(employ.getEmployeename());
		String url1 = "http://localhost:8082/admin/deletelogin"; // Deleting from login table
		String url2 = "http://localhost:8082/admin/delete"; // Deleting from employee table
		restTemplate.postForObject(url1, login, String.class);
		restTemplate.postForObject(url2, employee, String.class);
		return "redirect:AdminOperations.jsp";
	}

	@RequestMapping("/viewemployees")
	// This Method is called from the AdminOperations.jsp page and this method is
	// used to view employees from database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	public ModelAndView viewEmployees() {
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
				"http://localhost:8082/admin/viewemployees", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelView.addObject("list", responseEntity.getBody()); // List of employees
		modelView.setViewName("ListOfEmployees.jsp");
		return modelView;
	}

	@RequestMapping("/viewdepartments")
	// This Method is called from the AdminOperations.jsp page and this method is
	// used to view departments from database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	public ModelAndView viewDepartments() {
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
				"http://localhost:8082/admin/viewdepartments", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelView.addObject("list", responseEntity.getBody()); // View list of departments
		modelView.setViewName("ListOfDepartments.jsp");
		return modelView;
	}

	@RequestMapping("/listmanager")
	// This Method is called from the AdminOperations.jsp page and this method is
	// used to view list of employees reporting to specific manager from database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	public ModelAndView listmanager(HttpServletRequest request, HttpServletResponse response) {

		String reportingmanager = request.getParameter("manager");
		Employee employee = new Employee();
		employee.setReportingmanager(reportingmanager);
		RestTemplate rest = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<String>> responseEntity = rest.exchange(
				"http://localhost:8082/admin/listbymanager/" + reportingmanager, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		modelView.addObject("list", responseEntity.getBody());
		modelView.setViewName("EmployeeManager.jsp"); // list of employees reporting to specific manager
		return modelView;
	}

	@RequestMapping("/Calculatingpf")
	// This Method is called from the AdminOperations.jsp page and this method is
	// used to calculate pf of each employee from database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	public ModelAndView calculatingPf() {
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(
				"http://localhost:8082/admin/calculatingpf", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		modelView.addObject("list", responseEntity.getBody());
		modelView.setViewName("CalculatingPf.jsp"); // Calculating pf's of each employees
		return modelView;
	}

	@RequestMapping("/Salarybetween")
	// This Method is called from the AdminOperations.jsp page and this method is
	// used to view employees whose salary is between 10000 to 20000 from database.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	public ModelAndView Salarybetween() {
		RestTemplate rest = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<Employee>> responseEntity = rest.exchange("http://localhost:8082/admin/salarybetween",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {
				});
		modelView.addObject("list", responseEntity.getBody()); // Finding employees whose salary between 10000 to 20000
		modelView.setViewName("ListSalaryBetween.jsp");
		return modelView;
	}

}
