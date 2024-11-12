package none.spring_6_webapp.services;

import org.springframework.stereotype.Service;

import none.spring_6_webapp.domain.Book;
import none.spring_6_webapp.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@Override
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

}
