package co.istad.jparelationship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DemoJpaRelationshipApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void testInsertSingleAuthor() {
        Author author = new Author();
        author.setFullName("Lionel Messi");
        author.setEmail("messi@gmail.com");
        authorRepository.save(author);
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setId(1);
        author.setFullName("Chan Dara");
        author.setEmail("dara@gmail.com");
        authorRepository.save(author);
    }

    @Test
    void testSelectAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        authors.forEach(author -> System.out.println(author.getEmail() + " " + author.getFullName()));
    }


    @Test
    void testSelectAuthor() {
        Integer authorId = 1;
        Author author = authorRepository
                .findById(authorId)
                .orElseThrow();
        System.out.println(author.getEmail() + " " + author.getFullName());
    }


    @Test
    void testInsertAuthor() {

        Author author = new Author();
        author.setFullName("Chan Dara");
        author.setEmail("dara@gmail.com");

        Book book = new Book();
        book.setCode("B-002");
        book.setTitle("The lord of the ring");
        book.setAuthor(author);

        Chapter chapter1 = new Chapter();
        chapter1.setId("chapter3");
        chapter1.setTitle("The fellowship of the ring");
        chapter1.setPageNo(1);
        chapter1.setBook(book);

        Chapter chapter2 = new Chapter();
        chapter2.setId("chapter4");
        chapter2.setTitle("The Two Towers");
        chapter2.setPageNo(1000);
        chapter2.setBook(book);

        book.getChapters().add(chapter1);
        book.getChapters().add(chapter2);
        author.getBooks().add(book);

        authorRepository.save(author);
    }

}
