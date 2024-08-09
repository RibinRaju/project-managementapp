package com.example.projectmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectmanagementapp.model.Project;
import com.example.projectmanagementapp.model.Todo;
import com.example.projectmanagementapp.repository.ProjectRepository;
import com.example.projectmanagementapp.repository.TodoRepo;

@Service
public class TodoService {
	 @Autowired
	 TodoRepo todoRepository;
	 @Autowired
	 ProjectRepository projectRepository;
	 public Todo addTodoToProject(Long projectId, String description, String status) {
	        Optional<Project> optionalProject = projectRepository.findById(projectId);
	        if (optionalProject.isPresent()) {
	            Project project = optionalProject.get();
	            Todo todo = new Todo();
	            todo.setDescription(description);
	            todo.setStatus(status);
	            todo.setProject(project);
	            return todoRepository.save(todo);
	        }
	        return null;
	    }

	    public List<Todo> getTodosByProjectId(Long projectId) {
	        return todoRepository.findByProjectId(projectId);
	    }

	    public Todo updateTodo(Long todoId, String description, String status) {
	        Optional<Todo> optionalTodo = todoRepository.findById(todoId);
	        if (optionalTodo.isPresent()) {
	            Todo todo = optionalTodo.get();
	            todo.setDescription(description);
	            todo.setStatus(status);
	            return todoRepository.save(todo);
	        }
	        return null;
	    }

	    public boolean deleteTodo(Long todoId) {
	        if (todoRepository.existsById(todoId)) {
	            todoRepository.deleteById(todoId);
	            return true;
	        }
	        return false;
	    }

}
