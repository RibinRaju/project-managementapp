package com.example.projectmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.projectmanagementapp.model.Project;
import com.example.projectmanagementapp.model.Todo;
//import com.example.projectmanagementapp.repository.TodoRepo;
import com.example.projectmanagementapp.service.ProjectService;
import com.example.projectmanagementapp.service.TodoService;


	@Controller
	@RequestMapping("/projects")
	
	public class ProjectController {

		    @Autowired
		    private ProjectService projectService;
		    @Autowired
			private TodoService todoService;
		   
		    @GetMapping
		    public String showProjects(Model model) {
		        List<Project> projects = projectService.getAllProjects();
		        model.addAttribute("projects", projects);
		        return "projects"; 
		    }

		    @PostMapping
		    public String createProject(@RequestParam String title) {
		        projectService.createProject(title);
		        return "redirect:/projects";
		    }

		    @GetMapping("/{projectId}")
		    public String viewProject(@PathVariable Long projectId, Model model) {
		        Project project = projectService.getProjectById(projectId);
		        List<Todo> todos = todoService.getTodosByProjectId(projectId);
		        model.addAttribute("project", project);
		        model.addAttribute("todos", todos);
		        return "project";
		    }

		    @PostMapping("/{projectId}/update")
		    public String updateProject(@PathVariable Long projectId, @RequestParam String title) {
		        projectService.updateProject(projectId, title);
		        return "redirect:/projects/" + projectId;
		    }

		    @PostMapping("/{projectId}/delete")
		    public String deleteProject(@PathVariable Long projectId) {
		        projectService.deleteProject(projectId);
		        return "redirect:/projects";
		    }

		   

		    @PostMapping("/{projectId}/todos")
		    public String addTodo(@PathVariable Long projectId, @RequestParam String description, @RequestParam String status) {
		        todoService.addTodoToProject(projectId, description, status);
		        return "redirect:/projects/" + projectId;
		    }

		    @PostMapping("/{projectId}/todos/{todoId}/update")
		    public String updateTodo(@PathVariable Long projectId, @PathVariable Long todoId, @RequestParam String description, @RequestParam String status) {
		        todoService.updateTodo(todoId, description, status);
		        return "redirect:/projects/" + projectId;
		    }

		    @PostMapping("/{projectId}/todos/{todoId}/delete")
		    public String deleteTodo(@PathVariable Long projectId, @PathVariable Long todoId) {
		        todoService.deleteTodo(todoId);
		        return "redirect:/projects/" + projectId;
		    }
		
	}

