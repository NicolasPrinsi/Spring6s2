package none.spring_6_webapp.services;

import none.spring_6_webapp.domain.Author;

public interface AuthorService {

	Iterable<Author> findAll();
}
