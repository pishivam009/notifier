package com.piyush.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.piyush.demo.model.Notebook;

@Component
public interface NotebookRepository extends JpaRepository<Notebook, Integer>{

	Notebook findByNbname(String nbname);

}
