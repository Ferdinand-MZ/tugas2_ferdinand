package ferdinandmz.pencatatan.karyawan.service.impl;
import ferdinandmz.pencatatan.karyawan.entity.Karyawan;
import ferdinandmz.pencatatan.karyawan.repository.KaryawanRepository;
import ferdinandmz.pencatatan.karyawan.service.KaryawanService;

public class KaryawanServiceImpl implements KaryawanService {

    public KaryawanRepository karyawanRepository;

    public KaryawanServiceImpl(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public void add(String nama, String jabatan, Integer gaji) {
        // Initialize
        Karyawan karyawan = new Karyawan(nama, jabatan, gaji);

        // Add Karyawan
        karyawanRepository.add(karyawan);

        // Return
        System.out.println("Karyawan added successfully : " + karyawan.getNama());
    }

    @Override
    public void getAll() {
        // Initialize
        Karyawan[] list =  karyawanRepository.getAll();

        // Return
        for (Karyawan karyawan : list) {
            // 1.Nanti kita cerita hari ini ... (Orang - 2022)
            System.out.println(String.format("%d, %s -- (%s - %d)", karyawan.getId(), karyawan.getNama(), karyawan.getJabatan(), karyawan.getGaji()));
        }
    }

    @Override
    public void getById(Integer id) {
        // get data
        Karyawan karyawan = karyawanRepository.getById(id);

            // Return
            System.out.println(String.format("%d, %s -- (%s - %d)", karyawan.getId(), karyawan.getNama(), karyawan.getJabatan(), karyawan.getGaji()));
    }

    @Override
    public void update(Integer id, String nama, String jabatan, Integer gaji) {
        // Initialize
        Karyawan karyawan = new Karyawan(id, nama, jabatan, gaji);

        // Update Karyawan
        karyawanRepository.update(karyawan);

        // return
        System.out.println("Karyawan added successfully : " + karyawan.getNama());
    }

    @Override
    public void delete(Integer id) {
        // Delete data
        boolean success = karyawanRepository.delete(id); // true or false
        if (success) {
            // return 
            System.out.println("Karyawan deleted successfully : " + id);
        } else {
            // return
            System.out.println("Failed to Deleted Karyawan : " + id);
        }
    }

    @Override
    public void showDataByID(Object object, String nama, String jabatan, Integer valueOf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showDataByID'");
    }

    @Override
    public void deleteData(Object object, String nama, String jabatan, Integer valueOf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteData'");
    }
    
}
