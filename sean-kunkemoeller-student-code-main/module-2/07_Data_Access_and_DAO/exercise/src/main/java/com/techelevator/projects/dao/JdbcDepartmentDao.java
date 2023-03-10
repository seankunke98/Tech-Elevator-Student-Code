package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {
		Department department = new Department();
		String sql = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
		if(result.next()){
			department.setName(result.getString("name"));
			department.setId(result.getInt("department_id"));
		} else {
			return null;
		}

		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departmentList = new ArrayList<>();
		String sql = "SELECT * FROM department";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

		while(result.next()){
			departmentList.add(getDepartment(result.getInt("department_id")));
		}


		return departmentList;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sql = "UPDATE department SET name = ? WHERE department_id = ?";
		Integer updatedId = jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());

		if(updatedId == 1){
			System.out.println(updatedId);
		} else {
			System.out.println("Update Failed");
		}

	}

}
