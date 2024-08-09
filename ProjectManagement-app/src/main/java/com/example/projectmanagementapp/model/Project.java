package com.example.projectmanagementapp.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String title;

	    @Column(name = "created_date")
	    private LocalDateTime createdDate;

	    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Todo> todos;
	    public Project() {
	    	
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public LocalDateTime getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}

		public List<Todo> getTodos() {
			return todos;
		}

		public void setTodos(List<Todo> todos) {
			this.todos = todos;
		}

}
