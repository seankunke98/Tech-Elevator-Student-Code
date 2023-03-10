package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		Employee employee = new Employee();
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

		while(result.next()){
			employeeList.add(mapRowToEmployee(result));
		}

		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
		String searchTerm = "%" + firstNameSearch + "%";
		String secondSearchTerm = "%" + lastNameSearch + "%";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, searchTerm, secondSearchTerm);

		while(result.next()){
			employeeList.add(mapRowToEmployee(result));
		}

		return employeeList;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM employee JOIN project_employee ON employee.employee_id = project_employee.employee_id WHERE project_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, projectId);

		while(result.next()){
			employeeList.add(mapRowToEmployee(result));
		}
		return employeeList;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {

		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeList = new ArrayList<>();
		Employee employee = new Employee();
		String sql = "SELECT *\n" +
				"FROM employee LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id\n" +
				"WHERE project_employee.employee_id IS NULL";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

		while(result.next()){
			employeeList.add(mapRowToEmployee(result));
		}

		return employeeList;
	}

	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getInt("employee_id"));
		employee.setDepartmentId(result.getInt("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDate(result.getDate("birth_date").toLocalDate());
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		return employee;
	}

}
