package com.ribin.project.demoproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ribin.project.demoproject.model.Project;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,Long>{
	List<Project> findAll();

}
