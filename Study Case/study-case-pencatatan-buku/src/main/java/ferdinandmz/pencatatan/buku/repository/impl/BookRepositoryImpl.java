package ferdinandmz.pencatatan.buku.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ferdinandmz.pencatatan.buku.entity.Book;
import ferdinandmz.pencatatan.buku.repository.BookRepository;

public class BookRepositoryImpl implements BookRepository{

    private DataSource dataSource;

    public BookRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void add(Book book) {
                //Querry
                String sql = "INSERT INTO book(title,author,year) VALUES (?,?,?)";
        
                //Execute/Handle write to Database
               try(Connection connection = dataSource.getConnection(); 
               PreparedStatement statement = connection.prepareStatement(sql)) {
                //set value
                //set String(index, value)
                statement.setString(1, book.getTitle());
                statement.setString(2, book.getAuthor());
                statement.setInt(3, book.getYear());

                //Execute
                statement.executeUpdate();
                
               } catch (SQLException e) {
                throw new RuntimeException(e);
               }
    }

    @Override
    public Book[] getAll() {
        //Query
        String query = "SELECT id, title, author, year FROM book";
        
        //Execute / Handle select from Database
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

        // Initialize
        List<Book> list = new ArrayList<Book>();

        while (resultSet.next()){
            // Initialize
            Book book = new Book();

            // Set value
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setYear(resultSet.getInt("year"));

            // Add Book To List of Book
            list.add(book);
        }

        // Return List
        return list.toArray(new Book[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getById(Integer id) {
        // Query
        String query = "SELECT id, title, author, year FROM book WHERE id = ?";

        // Execute / Handle Select From Database
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(query)) {

            // set value
            statement.setInt(1, id);
            
            // Execute
            try (ResultSet resultSet = statement.executeQuery();){
                    // Initialize
            Book book = new Book();

            while (resultSet.next()) {
                // Set Value From Database
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setAuthor(resultSet.getString("author"));
                book.setYear(resultSet.getInt("year"));
            }

            // return Book
            return book;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Book book) {
       // Query
       String query = "UPDATE book SET title = ?, author = ?, year = ? WHERE id = ?";

        // Execute / Handle Update Database
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            // set value
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setInt(3, book.getYear());
            statement.setInt(4, book.getId());
            
            // Execute
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        // Query
        String query = "DELETE FROM book WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            // Set Value
            statement.setInt(1, id);

            // Execute
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }    
}
