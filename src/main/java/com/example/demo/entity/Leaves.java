package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="leaves")
public class Leaves {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int leaveid;
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;
	private String name;
	private Date startdate; 
	private Date enddate;
	private String Reason;
	private String status;
	public int getLeaveid() {
		return leaveid;
	}
	public void setLeaveid(int leaveid) {
		this.leaveid = leaveid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Leaves [leaveid=" + leaveid + ", employee=" + employee + ", name=" + name + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", Reason=" + Reason + ", status=" + status + "]";
	}
	
	

}

