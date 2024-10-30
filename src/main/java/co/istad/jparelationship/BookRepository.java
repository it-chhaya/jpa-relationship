package co.istad.jparelationship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByCodeAndAuthorId(String code, Integer authorId);

    List<Book> findByAuthor(Author author);

    // SELECT * FROM books WHERE author_id = ?
    List<Book> findByAuthorId(Integer authorId);

}
