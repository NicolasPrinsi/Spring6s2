package none.spring_6_webapp.services;

import none.spring_6_webapp.domain.Book;

public interface BookService {
		
	Iterable<Book> findAll();
}