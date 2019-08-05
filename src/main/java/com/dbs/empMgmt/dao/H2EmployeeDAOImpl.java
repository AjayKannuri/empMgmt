package com.dbs.empMgmt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dbs.empMgmt.model.Employee;

@Repository("h2Emp")
public class H2EmployeeDAOImpl implements EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

    @Autowired
    public H2EmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.execute("insert into employee values ('"+employee.getId()+" )");
        return employee;
	}

	@Override
	public Employee update(long empId, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		
	}

    
}
