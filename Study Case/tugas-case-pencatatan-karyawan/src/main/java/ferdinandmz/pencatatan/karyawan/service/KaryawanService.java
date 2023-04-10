package ferdinandmz.pencatatan.karyawan.service;

public interface KaryawanService {
    // Add
    public void add(String nama, String jabatan, Integer gaji);

    // Get All
    public void getAll();

    // Get Id
    public void getById(Integer id);

    // Update
    public void update(Integer id, String nama, String jabatan, Integer gaji);

    // Delete
    public void delete(Integer id);

    public void showDataByID(Object object, String nama, String jabatan, Integer valueOf);

    public void deleteData(Object object, String nama, String jabatan, Integer valueOf);
}
