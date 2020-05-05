package com.mac.java.spring5webapp.bootstrap;

import com.mac.java.spring5webapp.models.Author;
import com.mac.java.spring5webapp.models.Book;
import com.mac.java.spring5webapp.models.Publisher;
import com.mac.java.spring5webapp.repositories.AuthorRepository;
import com.mac.java.spring5webapp.repositories.BookRepository;
import com.mac.java.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        System.out.println("Bootstrap Constructed.");
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");
        Publisher publisher = new Publisher();
        publisher.setName("SFG Publisher");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        Author a1 = new Author("Eric", "Evans");
        Book b1 = new Book("Domain Driven Design", "12345");
        a1.getBooks().add(b1);
        b1.getAuthors().add(a1);
        b1.setPublisher(publisher);
        publisher.getBooks().add(b1);

        authorRepository.save(a1);
        bookRepository.save(b1);
        publisherRepository.save(publisher);

        Author a2 = new Author("Rod", "Johnson");
        Book b2 = new Book("J2EE Development with EJB", "12346");
        a2.getBooks().add(b2);
        b2.getAuthors().add(a2);
        b2.setPublisher(publisher);
        publisher.getBooks().add(b2);

        authorRepository.save(a2);
        bookRepository.save(b2);
        publisherRepository.save(publisher);
//        System.out.println("Number of books : " + bookRepository.count());
    }

}
