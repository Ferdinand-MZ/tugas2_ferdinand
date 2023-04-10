package ferdinandmz.pencatatan.karyawan;

import javax.sql.DataSource;

import ferdinandmz.pencatatan.karyawan.repository.KaryawanRepository;
import ferdinandmz.pencatatan.karyawan.repository.impl.KaryawanRepositoryImpl;
import ferdinandmz.pencatatan.karyawan.service.KaryawanService;
import ferdinandmz.pencatatan.karyawan.service.impl.KaryawanServiceImpl;
import ferdinandmz.pencatatan.karyawan.util.DatabaseUtil;
import ferdinandmz.pencatatan.karyawan.view.KaryawanView;

public class App 
{
    public static void main( String[] args ){
        // Data Source
        DataSource dataSource = DatabaseUtil.getDataSource();

        // Set Data Source
        KaryawanRepository karyawanRepository = new KaryawanRepositoryImpl(dataSource);
        KaryawanService karyawanService = new KaryawanServiceImpl(karyawanRepository);

        // View
        KaryawanView karyawanView = new KaryawanView(karyawanService);

        // Show View
        karyawanView.loginMenu();
    }
}
