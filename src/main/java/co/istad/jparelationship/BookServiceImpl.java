package co.istad.jparelationship;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final AuthorRepository authorRepository;

    @Transactional
    @Override
    public void deleteAuthorBook(Integer authorId) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow();
        author.getBooks().clear();
        authorRepository.save(author);
    }

}
