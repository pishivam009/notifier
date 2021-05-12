package com.piyush.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepo extends JpaRepository<Book, Integer>{

	Book findBybookId(int bookId);

	List<Book> getByGenre(String genre);

}
