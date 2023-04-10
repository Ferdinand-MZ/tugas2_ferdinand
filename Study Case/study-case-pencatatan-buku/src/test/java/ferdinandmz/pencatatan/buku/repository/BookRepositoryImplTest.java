package ferdinandmz.pencatatan.buku.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariDataSource;

import ferdinandmz.pencatatan.buku.entity.Book;
import ferdinandmz.pencatatan.buku.repository.impl.BookRepositoryImpl;
import ferdinandmz.pencatatan.buku.util.DatabaseUtil;

public class BookRepositoryImplTest {
    
    // data source
    private static HikariDataSource dataSource;

    // Book Repository
    private BookRepository bookRepository;

    @BeforeEach
    void setup (){
        dataSource = DatabaseUtil.getDataSource();
        bookRepository = new BookRepositoryImpl(dataSource);
    }

    @Test
    void testaddBook(){
        // Initialize
        Book book = new Book();

        // Set Value
        book.setTitle("Laskar Pelangi");
        book.setAuthor("Andrea Hirata");
        book.setYear(2005);

        // Add Book
        bookRepository.add(book);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
