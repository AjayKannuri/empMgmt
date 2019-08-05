package com.dbs.empMgmt.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.*;

import com.dbs.empMgmt.model.Employee;

@Repository("inMemory")
public class InMemoryEmployeeDAO implements EmployeeDAO {
	
	private static final List<Employee> empList = new ArrayList();

	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		empList.add(employee);
		System.out.println("Employee is added");
		return employee;
	}

	public Employee update(long empId, Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmp=empList.stream().filter(emp -> emp.getId() == empId).findFirst();
		optionalEmp.ifPresent(employee1 -> empList.add(empList.indexOf(employee),employee));
		return employee;
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empList;
	}

	public Employee findById(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> optionalEmployee = empList.stream().filter(employee -> employee.getId() == id).findFirst();
        if(optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }
        return null;
	}

	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
	}

}
