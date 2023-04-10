package ferdinandmz.pencatatan.buku.service.impl;
import ferdinandmz.pencatatan.buku.entity.Book;
import ferdinandmz.pencatatan.buku.repository.BookRepository;
import ferdinandmz.pencatatan.buku.service.BookService;

public class BookServiceImpl implements BookService {

    public BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(String title, String author, Integer year) {
        // Initialize
        Book book = new Book(title, author, year);

        // Add Book
        bookRepository.add(book);

        // Return
        System.out.println("Book added successfully : " + book.getTitle());
    }

    @Override
    public void getAll() {
        // Initialize
        Book[] list =  bookRepository.getAll();

        // Return
        for (Book book : list) {
            // 1.Nanti kita cerita hari ini ... (Orang - 2022)
            System.out.println(String.format("%d, %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
        }
    }

    @Override
    public void getById(Integer id) {
        // get data
        Book book = bookRepository.getById(id);

            // Return
            System.out.println(String.format("%d, %s -- (%s - %d)", book.getId(), book.getTitle(), book.getAuthor(), book.getYear()));
    }

    @Override
    public void update(Integer id, String title, String author, Integer year) {
        // Initialize
        Book book = new Book(id, title, author, year);

        // Update Book
        bookRepository.update(book);

        // return
        System.out.println("Book added successfully : " + book.getTitle());
    }

    @Override
    public void delete(Integer id) {
        // Delete data
        boolean success = bookRepository.delete(id); // true or false
        if (success) {
            // return 
            System.out.println("Book deleted successfully : " + id);
        } else {
            // return
            System.out.println("Failed to Deleted Book : " + id);
        }
    }

    @Override
    public void showDataByID(Object object, String title, String author, Integer valueOf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showDataByID'");
    }

    @Override
    public void deleteData(Object object, String title, String author, Integer valueOf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
    }
    
}
