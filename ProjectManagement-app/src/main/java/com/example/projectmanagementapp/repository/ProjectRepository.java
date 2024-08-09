package com.example.projectmanagementapp.repository;
import org.springframework.stereotype.Repository;

import com.example.projectmanagementapp.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
