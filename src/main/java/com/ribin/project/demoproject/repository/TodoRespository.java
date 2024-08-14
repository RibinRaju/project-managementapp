package com.ribin.project.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ribin.project.demoproject.model.Todo;

public interface TodoRespository extends JpaRepository<Todo,Long> {

}
