package ferdinandmz.pencatatan.karyawan.view;

import ferdinandmz.pencatatan.karyawan.service.KaryawanService;
import ferdinandmz.pencatatan.karyawan.util.InputUtil;

public class KaryawanView {
    
    // Book Service
    private KaryawanService karyawanService;

    public KaryawanView(KaryawanService karyawanService) {
        this.karyawanService = karyawanService;
    }

    // Login Menu
    public void loginMenu() {
        System.out.println("============= LOGIN =============");
        String username = InputUtil.input("Username: ");
        String password = InputUtil.input("Password: ");

        // autentikasi user
        if (username.equals("user") && password.equals("password")) {
            // show user menu
            showUserMenu();
        }
        // autentikasi admin
        else if (username.equals("ferdinandmz") && password.equals("asphyxia")) {
            // show admin menu
            showAdminMenu();
        }
        // gagal autentikasi
        else {
            System.out.println("Username atau password salah!");
            // kembali ke menu login
            loginMenu();
        }
    }

    // Show User Menu
    private void showUserMenu() {
        while(true){
            System.out.println("============= USER MENU =============");
            System.out.println("1. Show Data");
            System.out.println("2. Show Data By ID");
            System.out.println("X. Exit");

            String input = InputUtil.input("Choose >");

            if (input.equals("1")) {
                showData();
            } else if (input.equals("2")) {
                showDataByID();
            } else if (input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Option doesn't recognized");
            }
        }
    }

    // Show Admin Menu
    private void showAdminMenu() {
        while(true){
            System.out.println("============= ADMIN MENU =============");
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Show Data");
            System.out.println("4. Show Data By ID");
            System.out.println("5. Delete Data");
            System.out.println("X. Exit");

            String input = InputUtil.input("Choose >");

            if (input.equals("1")) {
                insertData();
            } else if (input.equals("2")) {
                updateData();
            } else if (input.equals("3")) {
                showData();
            } else if (input.equals("4")) {
                showDataByID();
            } else if (input.equals("5")) {
                deleteData();
            } else if (input.equalsIgnoreCase("x")) {
                break;
            } else {
                System.out.println("Option doesn't recognized");
            }
        }
    }


    private void deleteData() {
        System.out.println("============= DELETE DATA BY ID =============");
        
        // Get Data Input
        String id = InputUtil.input("ID");

        // Delete Data
        karyawanService.delete(Integer.valueOf(id));
    }

    // Show Data By ID
    private void showDataByID() {
        System.out.println("============= SHOW DATA BY ID =============");
        
        // Get Data Input
        String Id = InputUtil.input("ID");

        // Update Data
        karyawanService.getById(Integer.valueOf(Id));
    }

    private void updateData() {
        System.out.println("============= UPDATE DATA =============");
        
        // Get Data Input
        String id = InputUtil.input("ID");
        String nama = InputUtil.input("Nama");
        String jabatan = InputUtil.input("Jabatan");
        String gaji = InputUtil.input("Gaji");

        // Update Data
        karyawanService.update(Integer.valueOf(id), nama, jabatan, Integer.valueOf(gaji));
    }

    // Insert Data
    public void insertData() {
        System.out.println("============= INSERT DATA =============");
        
        // Get Data Input
        String nama = InputUtil.input("Nama");
        String jabatan = InputUtil.input("Jabatan");
        String gaji = InputUtil.input("Gaji");

        // Add Data
        karyawanService.add(nama, jabatan, Integer.valueOf(gaji));
    }

    // Show Data
    public void showData() {
        // Menu
        System.out.println("============= SHOW DATA =============");

        // Get Data
        karyawanService.getAll();
    }
}
