package com.dbs.empMgmt.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
		int id = (int) employee.getId();
		String name = employee.getName();
		String date = employee.getDateOfBirth().toString();
		String deptName = employee.getDepartmentName();
		String sql_query = "insert into employee values('"+id+"','"+name+"','"+date+"','"+deptName+"')";
		this.jdbcTemplate.execute(sql_query);
		System.out.println("Employee has been saved");
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
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		return this.jdbcTemplate.query("select * from employee",new RowMapper<Employee>(){  
		    @Override  
		    public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        Employee e=new Employee();  
		        e.setId(rs.getInt(1));  
		        e.setName(rs.getString(2));
		        LocalDate localDateObj = LocalDate.parse(rs.getString(3), dateTimeFormatter);
		        e.setDateOfBirth(localDateObj); 
		        e.setDepartmentName(rs.getString(4));
		        return e;  
		    }  
		    }); 

	}

	@Override
	public Employee findById(long id) {
		// TODO Auto-generated method stub
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String query = "select * from employee where id="+id;
		return this.jdbcTemplate.queryForObject(query, (rs,i)->{
					Employee e=new Employee();  
			        e.setId(rs.getInt(1));  
			        e.setName(rs.getString(2));
			        LocalDate localDateObj = LocalDate.parse(rs.getString(3), dateTimeFormatter);
			        e.setDateOfBirth(localDateObj); 
			        e.setDepartmentName(rs.getString(4));
			        return e;
		});
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		String deleteQuery = "delete from employee where id="+id;
		int k =this.jdbcTemplate.update(deleteQuery);
		if(k>0)
			System.out.println("the record is deleted");
		
	}

    
}
