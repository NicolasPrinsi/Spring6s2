package none.spring_6_webapp.services;

import org.springframework.stereotype.Service;

import none.spring_6_webapp.domain.Author;
import none.spring_6_webapp.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepository;
	

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}



	@Override
	public Iterable<Author> findAll() {
		return authorRepository.findAll();
	}

}
