package co.istad.jparelationship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = """
        SELECT book
        FROM Book AS book
        WHERE book.code = ?1
    """)
    List<Book> selectBooksByCode(String code);

    List<Book> findByCodeAndAuthorId(String code, Integer authorId);

    List<Book> findByAuthor(Author author);

    // SELECT * FROM books WHERE author_id = ?
    List<Book> findByAuthorId(Integer authorId);

}
