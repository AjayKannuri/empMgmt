package com.dbs.empMgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dbs.empMgmt.dao.EmployeeDAO;
import com.dbs.empMgmt.model.Employee;

@Service
public class EployeeServiceImpl implements EmployeeService{

	 	private EmployeeDAO employeeDAO;

	    @Autowired
	    public EployeeServiceImpl(@Qualifier("h2Emp")EmployeeDAO employeeDAO){
	        this.employeeDAO = employeeDAO;
	    }

	    @Override
	    public Employee saveEmployee(Employee employee) {
	        return employeeDAO.save(employee);
	    }

	    @Override
	    public List<Employee> listAll() {
	        return this.employeeDAO.findAll();
	    }

	    @Override
	    public Employee findById(long empId)  {
	        return this.employeeDAO.findById(empId);
	    }

	    @Override
	    public void deleteEmployee(long empId) {
	        this.employeeDAO.deleteEmployee(empId);
	    }
	
	
	

}
