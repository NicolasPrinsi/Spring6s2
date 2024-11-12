package none.spring_6_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner; 
import org.springframework.stereotype.Component;

import none.spring_6_webapp.domain.Author;
import none.spring_6_webapp.domain.Book;
import none.spring_6_webapp.domain.Publisher;
import none.spring_6_webapp.repositories.AuthorRepository;
import none.spring_6_webapp.repositories.BookRepository;
import none.spring_6_webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	

	public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}



	@Override
	public void run(String... args) throws Exception {
		Author eric = new Author();
		eric.setFirstName("Eric");
		eric.setLastName("Evans");
		
		Book ddd = new Book();
		ddd.setTitle("Domain Driven Design");
		ddd.setIsbn("118903");
		
		Author ericSaved = authorRepository.save(eric);
		Book dddSaved = bookRepository.save(ddd);
		
		Author rod = new Author();
		rod.setFirstName("Rod");
		rod.setLastName("Johnson");
		
		Book noEJB = new Book();
		noEJB.setTitle("J2EE Development without EJB");
		noEJB.setIsbn("260298");
		
		Author rodSaved = authorRepository.save(rod);
		Book noEJBSaved = bookRepository.save(noEJB);
		
		ericSaved.getBooks().add(dddSaved);
		rodSaved.getBooks().add(noEJBSaved);
		
		Publisher publisher = new Publisher();
		publisher.setPublisherName("My Publisher");
		publisher.setAddress("123 CalleFalsa");
		Publisher publisherSaved = publisherRepository.save(publisher);
		
		dddSaved.setPublisher(publisherSaved);
		noEJBSaved.setPublisher(publisherSaved);
		dddSaved.getAuthors().add(ericSaved);
		noEJBSaved.getAuthors().add(rodSaved);
		
		authorRepository.save(ericSaved);
		authorRepository.save(rodSaved);
		bookRepository.save(dddSaved);
		bookRepository.save(noEJBSaved);
		
		System.out.println("In BootStrap");
		System.out.println("Author Count: "+ authorRepository.count());
		System.out.println("Book Count: "+ bookRepository.count());
		
		System.out.println("Publisher Count: "+ publisherRepository.count());
	}

}
