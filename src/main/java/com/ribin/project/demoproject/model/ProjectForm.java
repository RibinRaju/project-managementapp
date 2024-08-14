package com.ribin.project.demoproject.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectForm {
    private String title;
    private List<TodoForm> todos = new ArrayList<>();

    

    public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public List<TodoForm> getTodos() {
		return todos;
	}



	public void setTodos(List<TodoForm> todos) {
		this.todos = todos;
	}



	public static class TodoForm {
		private boolean status;

        private String description;
        public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		
        
    }
}
