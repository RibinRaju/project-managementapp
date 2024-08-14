package com.ribin.project.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ribin.project.demoproject.model.Project;
import com.ribin.project.demoproject.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional
    public void saveProject(Project project) {
        projectRepository.save(project);
    }
    public List<Project> findAllProjects(){
    	return projectRepository.findAll();
    }
}
