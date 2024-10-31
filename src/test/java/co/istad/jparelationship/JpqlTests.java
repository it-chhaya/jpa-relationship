package co.istad.jparelationship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpqlTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testJpql() {
        List<Book> bookList = bookRepository.selectBooksByCode("B-006");
        System.out.println(bookList.getFirst().getTitle());
    }

}
