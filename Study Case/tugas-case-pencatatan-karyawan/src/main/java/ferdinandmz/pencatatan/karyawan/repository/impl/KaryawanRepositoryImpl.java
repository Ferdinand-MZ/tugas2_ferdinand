package ferdinandmz.pencatatan.karyawan.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import ferdinandmz.pencatatan.karyawan.entity.Karyawan;
import ferdinandmz.pencatatan.karyawan.repository.KaryawanRepository;

public class KaryawanRepositoryImpl implements KaryawanRepository{

    private DataSource dataSource;

    public KaryawanRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void add(Karyawan karyawan) {
                //Querry
                String sql = "INSERT INTO karyawan(nama,jabatan,gaji) VALUES (?,?,?)";
        
                //Execute/Handle write to Database
               try(Connection connection = dataSource.getConnection(); 
               PreparedStatement statement = connection.prepareStatement(sql)) {
                //set value
                //set String(index, value)
                statement.setString(1, karyawan.getNama());
                statement.setString(2, karyawan.getJabatan());
                statement.setInt(3, karyawan.getGaji());

                //Execute
                statement.executeUpdate();
                
               } catch (SQLException e) {
                throw new RuntimeException(e);
               }
    }

    @Override
    public Karyawan[] getAll() {
        //Query
        String query = "SELECT id, nama, jabatan, gaji FROM karyawan";
        
        //Execute / Handle select from Database
        try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query)) {

        // Initialize
        List<Karyawan> list = new ArrayList<Karyawan>();

        while (resultSet.next()){
            // Initialize
            Karyawan karyawan = new Karyawan();

            // Set value
            karyawan.setId(resultSet.getInt("id"));
            karyawan.setNama(resultSet.getString("nama"));
            karyawan.setJabatan(resultSet.getString("jabatan"));
            karyawan.setGaji(resultSet.getInt("gaji"));

            // Add Book To List of Book
            list.add(karyawan);
        }

        // Return List
        return list.toArray(new Karyawan[] {});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Karyawan getById(Integer id) {
        // Query
        String query = "SELECT id, nama, jabatan, gaji FROM karyawan WHERE id = ?";

        // Execute / Handle Select From Database
        try (Connection connection = dataSource.getConnection(); 
        PreparedStatement statement = connection.prepareStatement(query)) {

            // set value
            statement.setInt(1, id);
            
            // Execute
            try (ResultSet resultSet = statement.executeQuery();){
                    // Initialize
            Karyawan karyawan = new Karyawan();

            while (resultSet.next()) {
                // Set Value From Database
                karyawan.setId(resultSet.getInt("id"));
                karyawan.setNama(resultSet.getString("nama"));
                karyawan.setJabatan(resultSet.getString("jabatan"));
                karyawan.setGaji(resultSet.getInt("gaji"));
            }

            // return karyawan
            return karyawan;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Karyawan karyawan) {
       // Query
       String query = "UPDATE karyawan SET nama = ?, jabatan = ?, gaji = ? WHERE id = ?";

        // Execute / Handle Update Database
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query)){

            // set value
            statement.setString(1, karyawan.getNama());
            statement.setString(2, karyawan.getJabatan());
            statement.setInt(3, karyawan.getGaji());
            statement.setInt(4, karyawan.getId());
            
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
        String query = "DELETE FROM karyawan WHERE id = ?";

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
