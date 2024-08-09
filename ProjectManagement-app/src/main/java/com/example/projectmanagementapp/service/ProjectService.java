package com.example.projectmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementapp.model.Project;
import com.example.projectmanagementapp.repository.ProjectRepository;
import com.example.projectmanagementapp.repository.TodoRepo;

@Service
public class ProjectService {
	 	@Autowired
	    private ProjectRepository projectRepository;

	    @Autowired
	    private TodoRepo  todoRepository;

	    public Project createProject(String title) {
	        Project project = new Project();
	        project.setTitle(title);
	        return projectRepository.save(project);
	    }

	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	    public Project getProjectById(Long id) {
	        return projectRepository.findById(id).orElse(null);
	    }

	    public Project updateProject(Long id, String title) {
	        Optional<Project> optionalProject = projectRepository.findById(id);
	        if (optionalProject.isPresent()) {
	            Project project = optionalProject.get();
	            project.setTitle(title);
	            return projectRepository.save(project);
	        }
	        return null;
	    }

	    public boolean deleteProject(Long id) {
	        if (projectRepository.existsById(id)) {
	            projectRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

}
