package com.ribin.project.demoproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ribin.project.demoproject.model.Project;
import com.ribin.project.demoproject.model.Todo;
import com.ribin.project.demoproject.model.ProjectForm;
import com.ribin.project.demoproject.service.ProjectService;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String home(Model model) {
    	 model.addAttribute("list",projectService.findAllProjects());
         
        return "home";
    }

    @GetMapping("/createproject")
    public String newPage(Model model) {
        model.addAttribute("projectForm", new ProjectForm());
         return "createproject";
    }

    @PostMapping("/save")
    public String createProject(@ModelAttribute ProjectForm form) {
        Project project = new Project();
        project.setTitle(form.getTitle());
        project.setCreatedDate(LocalDate.now());

        List<Todo> todos = form.getTodos().stream().map(todoForm -> {
            Todo todo = new Todo();
            todo.setDescription(todoForm.getDescription());
            todo.setStatus(todoForm.isStatus());
            todo.setCreatedDate(LocalDate.now());
            todo.setUpdatedDate(LocalDate.now());
            todo.setProject(project);
            return todo;
        }).collect(Collectors.toList());

        project.setTodos(todos);
        projectService.saveProject(project);

        return "redirect:/";
    }
}
