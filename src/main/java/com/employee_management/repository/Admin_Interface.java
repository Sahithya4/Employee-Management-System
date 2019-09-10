package com.employee_management.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee_management.entity.Employee;
@Repository
public interface Admin_Interface extends JpaRepository<Employee,Integer>{

}

