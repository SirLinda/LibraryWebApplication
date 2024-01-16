package com.application.library;

import com.application.library.entity.Author;
import com.application.library.entity.Book;
import com.application.library.entity.Category;
import com.application.library.entity.Publisher;
import com.application.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService){
		return (args) ->{
			Book           book1;
			Author       author1;
			Category   category1;
			Publisher publisher1;

			book1      = new Book("ABC","Book name","My first book");
			author1    = new Author("Author name", "Author description");
			category1  = new Category("First book category");
			publisher1 = new Publisher("First Publisher");

			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);

			bookService.createBook(book1);


			Book           book2;
			Author       author2;
			Category   category2;
			Publisher publisher2;

			book2      = new Book("ABC1","Book name1","My second book");
			author2    = new Author("Author name1", "Author description1");
			category2  = new Category("Second book category");
			publisher2 = new Publisher("Second Publisher");

			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);

			bookService.createBook(book2);


			Book           book3;
			Author       author3;
			Category   category3;
			Publisher publisher3;

			book3      = new Book("ABC2","Book name2","My second book");
			author3    = new Author("Author name2", "Author description2");
			category3  = new Category("Third book category");
			publisher3 = new Publisher("Third Publisher");

			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);

			bookService.createBook(book3);
		};
	}

}
