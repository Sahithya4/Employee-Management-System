package com.employee_management.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.employee_management.entity.Employee;
import com.employee_management.entity.Leaves;

@Controller
public class UserController {

	// This Method is called from the LoginController page and to check whether
	// employee is manager or not.
	// After this method gets executed it is forwarded to the AdminRestController
	// where rest calls are made.
	@RequestMapping(value = "/checkuser", method = RequestMethod.POST) // This method is to check whether employee is
																		// manager or not
	public ModelAndView checkUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String reportingmanager = (String) session.getAttribute("username");
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
				"http://localhost:8082/admin/listbymanager/" + reportingmanager, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		modelView.addObject("list", responseEntity.getBody());
		if (responseEntity.getBody().isEmpty()) // Checking whether user is manager or not
			modelView.setViewName("UserOperations.jsp"); // if not go to user operations
		else
			modelView.setViewName("ManagerOperations.jsp");// else go to manager operations
		return modelView;
	}

	// This Method is called from the Apply_Leave.jsp page and this method is used
	// to add a leave to database.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/apply") // This method is to apply the leave by employees
	public String deletecontroller(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Employee employee = new Employee();
		Leaves leave = new Leaves();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		String startdate = request.getParameter("sd");
		String enddate = request.getParameter("ed");
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(startdate);
			leave.setStartdate(date);
			date = new SimpleDateFormat("yyyy-MM-dd").parse(enddate);
			leave.setEnddate(date);
			leave.setReason(request.getParameter("reason"));
			leave.setStatus("pending");
			leave.setName(name);
			String url = "http://localhost:8082/user/find/" + name;
			RestTemplate restTemplate = new RestTemplate();
			Employee employ = restTemplate.postForObject(url, employee, Employee.class);
			leave.setEmployee(employ);
			String url1 = "http://localhost:8082/user/add";
			restTemplate.postForObject(url1, leave, String.class); // Adding into leaves table
			session.setAttribute("status", "pending");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return "UserOperations.jsp";
	}

	// This Method is called from the UserOperations.jsp page and this method is
	// used to view leaves from database.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/viewleave") // This method is to view the leaves applied by employees
	public String viewLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username"); // getting username to get the list of employees
																	// working under specific manager
		RestTemplate restTemplate = new RestTemplate();
		ModelAndView modelView = new ModelAndView();
		ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
				"http://localhost:8082/admin/listbymanager/" + name, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		modelView.addObject("list", responseEntity.getBody());
		request.setAttribute("list", responseEntity.getBody());
		ArrayList<String> list = (ArrayList<String>) request.getAttribute("list");
		ArrayList<Leaves> arrayList = new ArrayList<Leaves>();
		for (int i = 0; i < list.size(); i++) {
			String eachemployee = list.get(i);
			ResponseEntity<Leaves> responseEntity1 = restTemplate.exchange(
					"http://localhost:8082/user/viewleaves/" + eachemployee, HttpMethod.GET, null,
					new ParameterizedTypeReference<Leaves>() {
					});
			leave = responseEntity1.getBody();
			if (leave != null)
				arrayList.add(leave);
		}
		request.setAttribute("list1", arrayList);// view no of leaves applied by employees working under specific
													// manager
		modelView.addObject("list1", arrayList);
		return "ViewLeaves.jsp";
	}

	// This Method is called from the ViewLeaves.jsp page and this method is used to
	// accept a leave to database.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/accept") // This method is to reject the leave applied
	public String acceptLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		String id = request.getParameter("id");
		int leaveid = Integer.parseInt(id);
		leave.setLeaveid(leaveid);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/user/accept"; // accepting leave
		restTemplate.postForObject(url, leave, String.class);
		HttpSession session = request.getSession();
		session.setAttribute("status", "accepted"); // updating status to accepted
		return "login.jsp";
	}

	// This Method is called from the ViewLeaves.jsp page and this method is used to
	// reject a leave to database.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/reject") // This method is to accept the leave applied
	public String rejectLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		String id = request.getParameter("id");
		int leaveid = Integer.parseInt(id);
		leave.setLeaveid(leaveid);
		System.out.println(leave.getLeaveid());
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8082/user/reject"; // rejecting leave
		restTemplate.postForObject(url, leave, String.class);
		HttpSession session = request.getSession();
		session.setAttribute("status", "rejected"); // Updating status to reject
		return "login.jsp";
	}

	// This Method is called from the UserOperations.jsp/ManagerOperations.jsp page
	// and this method is used to cancel a leave from database.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/cancel") // This method is to cancel the leave which is applied
	public String cancelLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		leave.setName(name);
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "http://localhost:8082/user/cancel/" + name;
		Leaves status = restTemplate.postForObject(url1, leave, Leaves.class);
		leave.setLeaveid(status.getLeaveid());
		String url = "http://localhost:8082/user/cancel"; // Cancel leave
		restTemplate.postForObject(url, leave, String.class);
		session = request.getSession();
		session.setAttribute("status", "canceled");// Updating status to canceled
		return "login.jsp";
	}

	// This Method is called from the ManagerOperations.jsp page and this method is
	// used to check leave status a leave from database of manager.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/statusofmanager") // This method is to view leave status of manager
	public String statusmanagerLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		leave.setName(name);
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "http://localhost:8082/user/cancel/" + name;
		Leaves status = restTemplate.postForObject(url1, leave, Leaves.class);
		if (status != null) {
			leave.setLeaveid(status.getLeaveid());
			String url = "http://localhost:8082/user/status"; // to view leave status
			String status1 = restTemplate.postForObject(url, leave, String.class);
			session.setAttribute("status", status1);// Updating status
		} else {
			session.setAttribute("status", null); // if not yet applied for leave status is null
		}
		return "StatusOfManager.jsp";
	}

	// This Method is called from the UserOperations.jsp page and this method is
	// used to check leave status a leave from database of employee.
	// After this method gets executed it is forwarded to the UserRestController
	// where rest calls are made.
	@RequestMapping(value = "/statusofemployee") // This method is to view leave status of employee
	public String statusemployeeLeaves(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Leaves leave = new Leaves();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");
		leave.setName(name);
		RestTemplate restTemplate = new RestTemplate();
		String url1 = "http://localhost:8082/user/cancel/" + name;
		Leaves status = restTemplate.postForObject(url1, leave, Leaves.class);
		if (status != null) {
			leave.setLeaveid(status.getLeaveid());
			String url = "http://localhost:8082/user/status"; // to view leave status
			String status1 = restTemplate.postForObject(url, leave, String.class);
			session.setAttribute("status", status1);// Updating status
		} else {
			session.setAttribute("status", null); // if not yet applied for leave status is null
		}
		return "StatusOfEmployee.jsp";
	}
}
