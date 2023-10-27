package me.lirodek.querydsl2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;



import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;



@DataJpaTest
class QueryDsl2ApplicationTests {

	@Autowired
	BookRepository bookRepository;



	@Test
	void contextLoads() {
		Book book = new Book();
		book.setTitle("Elone");
		book.setContent("musk");
		Book newBook = bookRepository.save(book);

		assertTrue(bookRepository.contains(newBook));

		Optional<Book> one = bookRepository.findOne(QBook.book.title.contains("one"));
		assertTrue(one.isPresent());


	}

}
