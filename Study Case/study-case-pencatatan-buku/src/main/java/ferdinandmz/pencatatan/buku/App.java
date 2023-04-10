package ferdinandmz.pencatatan.buku;

import javax.sql.DataSource;

import ferdinandmz.pencatatan.buku.repository.BookRepository;
import ferdinandmz.pencatatan.buku.repository.impl.BookRepositoryImpl;
import ferdinandmz.pencatatan.buku.service.BookService;
import ferdinandmz.pencatatan.buku.service.impl.BookServiceImpl;
import ferdinandmz.pencatatan.buku.util.DatabaseUtil;
import ferdinandmz.pencatatan.buku.view.BookView;

public class App 
{
    public static void main( String[] args ){
        // Data Source
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set Data Source
        BookRepository bookRepository = new BookRepositoryImpl(dataSource);
        BookService bookService = new BookServiceImpl(bookRepository);

        // View
        BookView bookView = new BookView(bookService);

        // Show View
        bookView.showMenu();
    }
}
