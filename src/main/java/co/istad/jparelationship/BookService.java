package co.istad.jparelationship;

import java.util.List;

public interface BookService {

    void findByCodeAndAuthorId(String code, Integer authorId);

    void findByAuthor(Integer authorId);

    void findBookByAuthorId(Integer authorId);

    void deleteAuthorBook(Integer authorId);

}
