package com.example.projectmanagementapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectmanagementapp.model.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Long> {
	
	List<Todo> findByProjectId(Long projectId);
}
