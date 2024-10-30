package co.istad.jparelationship;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    @Override
    public void findByCodeAndAuthorId(String code, Integer authorId) {

    }

    @Transactional
    @Override
    public void findByAuthor(Integer authorId) {
        Author myAuthor = authorRepository
                .findById(authorId)
                .orElseThrow();
        bookRepository
                .findByAuthor(myAuthor)
                .forEach(book -> System.out.println(book.getAuthor()));
    }

    @Transactional
    @Override
    public void findBookByAuthorId(Integer authorId) {
        bookRepository
                .findByAuthorId(authorId)
                .forEach(book -> System.out.println(book.getAuthor()));
    }


    @Transactional
    @Override
    public void deleteAuthorBook(Integer authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow();
        author.getBooks().clear();
        authorRepository.save(author);
    }

}
