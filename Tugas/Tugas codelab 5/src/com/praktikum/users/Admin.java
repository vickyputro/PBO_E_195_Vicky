package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;

import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions
{
    private String username ;
    private String password ;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void displayAppMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do{
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Logout...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }

    @Override
    public void displayinfo(){
        System.out.println("Login Admin Berhasil");
        super.displayinfo();
    }

    @Override
    public void manageItems()
    {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n== Kelola Laporan ==");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        if (LoginSystem.reportedItem.isEmpty()){
                            System.out.println("Belum ada laporan barang.");
                        }else {
                            for (int i = 0; i < LoginSystem.reportedItem.size(); i++) {
                                System.out.println("\nItem #" + (i + 1));
                                System.out.println(LoginSystem.reportedItem.get(i));
                            }
                        }
                        break;
                    case 2:
                        boolean addreport = false;
                        int index = 0;
                        for (int i = 0; i < LoginSystem.reportedItem.size(); i++) {
                            if (LoginSystem.reportedItem.get(i).getStatus().equals("Reported")) {
                                addreport = true;
                                System.out.println(i + ". " + LoginSystem.reportedItem.get(i).getItemName());
                            }
                        }
                        if (!addreport) {
                            System.out.println("Tidak ada item dengan status 'Reported'.");
                            break;
                        }
                        System.out.print("Masukkan indeks item yang akan ditandai: ");
                        try {
                            index = scanner.nextInt();
                            scanner.nextLine();
                            if (LoginSystem.reportedItem.get(index).getStatus().equals("Reported")) {
                                LoginSystem.reportedItem.get(index).setStatus("Claimed");
                                System.out.println(">> Status item berhasil diubah menjadi 'Claimed'.");
                            } else {
                                System.out.println(">> Item tersebut sudah ditandai.");
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(">> Indeks tidak valid.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println(">> Input harus berupa angka (0-2)");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    @Override
    public void manageUsers()
    {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n== Kelola Mahasiswa ==");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama Mahasiswa: ");
                        String nama = scanner.nextLine();
                        System.out.print("NIM Mahasiswa: ");
                        String nim = scanner.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa berhasil ditambahkan.");
                        break;
                    case 2:
                        if (LoginSystem.userList.isEmpty()) {
                            System.out.println(">> Tidak ada data mahasiswa.");
                            break;
                        }

                        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
                        String targetNIM = scanner.nextLine();
                        boolean ditemukan = false;

                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        while (iterator.hasNext()) {
                            User user = iterator.next();
                            if (user instanceof Mahasiswa && user.getNim().equals(targetNIM)) {
                                System.out.println("\n== Data Mahasiswa Ditemukan ==");
                                System.out.println("Nama: " + user.getNama());
                                System.out.println("NIM : " + user.getNim());

                                System.out.print("Apakah Anda yakin ingin menghapus mahasiswa ini? (y/n): ");
                                String konfirmasi = scanner.nextLine();
                                if (konfirmasi.equalsIgnoreCase("y")) {
                                    iterator.remove();
                                    System.out.println(">> Mahasiswa berhasil dihapus.");
                                } else {
                                    System.out.println(">> Penghapusan dibatalkan.");
                                }
                                ditemukan = true;
                                break;
                            }
                        }
                        if (!ditemukan) {
                            System.out.println(">> Mahasiswa dengan NIM tersebut tidak ditemukan.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (java.util.InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }
}
