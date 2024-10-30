package co.istad.jparelationship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DqmTests {

    @Autowired
    private BookService bookService;

    @Test
    void testFindBookByAuthor() {
        bookService.findByAuthor(17);
    }

    @Test
    void testFindBookByAuthorId() {
        bookService.findBookByAuthorId(17);
    }

}
