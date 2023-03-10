package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		Project project = new Project();
		String sql = "SELECT project_id, name, from_date, to_date FROM project WHERE project_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql, projectId);
		if(result.next()){
			if(result.getDate("from_date") != null){
				project.setFromDate(result.getDate("from_date").toLocalDate());
			} else {
				project.setFromDate(null);
			}
			if(result.getDate("to_date") != null){
				project.setToDate(result.getDate("to_date").toLocalDate());
			} else {
				project.setToDate(null);
			}
			project.setId(result.getInt("project_id"));
			project.setName(result.getString("name"));
		} else {
			return null;
		}


		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();
		String sql = "SELECT * FROM project";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

		while(result.next()){
			projectList.add(getProject(result.getInt("project_id")));
		}

		return projectList;
	}

	@Override
	public Project createProject(Project newProject) {
		String sql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?) returning project_id";
		Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		newProject.setId(newId);
		return newProject;
	}

	@Override
	public void deleteProject(int projectId) {
		String deleteProjectKeySql = "DELETE FROM project_employee WHERE project_id = ?";
		jdbcTemplate.update(deleteProjectKeySql, projectId);
		String sql = "DELETE FROM project WHERE project_id = ?";
		jdbcTemplate.update(sql, projectId);

	}
	

}
