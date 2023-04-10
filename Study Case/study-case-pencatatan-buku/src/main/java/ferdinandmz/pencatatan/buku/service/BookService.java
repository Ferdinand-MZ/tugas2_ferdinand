package ferdinandmz.pencatatan.buku.service;

public interface BookService {
    // Add
    public void add(String title, String author, Integer year);

    // Get All
    public void getAll();

    // Get Id
    public void getById(Integer id);

    // Update
    public void update(Integer id, String title, String author, Integer year);

    // Delete
    public void delete(Integer id);

    public void showDataByID(Object object, String title, String author, Integer valueOf);

    public void deleteData(Object object, String title, String author, Integer valueOf);
}
