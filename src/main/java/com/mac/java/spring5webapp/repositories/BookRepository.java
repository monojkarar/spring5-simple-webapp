package com.mac.java.spring5webapp.repositories;

import com.mac.java.spring5webapp.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
