package com.employee_management.repository;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee_management.entity.Employee;

public interface Employee_Interface extends JpaRepository<Employee,String>{

	@Query("SELECT e.employeename FROM Employee e WHERE e.reportingmanager =:reportingmanager")
	public ArrayList<String> getReportingmanagers(@Param("reportingmanager") String reportingmanager);
	
	@Query("SELECT e FROM Employee e where e.salary between 10000 and 20000")
	public ArrayList<Employee> getSalarybetween();
	
	@Query("SELECT e FROM Employee e where e.employeename =:employeename")
	public Employee getEmployee(@Param("employeename") String employeename);

}
