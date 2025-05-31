package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions
{
    public Mahasiswa(String nama,String nim)
    {
        super(nama, nim);
    }

    @Override
    public boolean login(String nama, String nimInput) {
        return this.getNama().equals(nama) && this.getNim().equals(nimInput);
    }

    @Override
    public void displayAppMenu()
    {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n== Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
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
    public void displayinfo() {
        System.out.println("Login Mahasiswa Berhasil");
        super.displayinfo();
    }

    @Override
    public void reportItem()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasi = scanner.nextLine();

        Item item = new Item(nama, deskripsi, lokasi);
        LoginSystem.reportedItem.add(item);
        System.out.println("Laporan berhasil disimpan!");
    }

    @Override
    public void viewReportedItems()
    {
        boolean ada = false;
        for (Item item : LoginSystem.reportedItem){
            if (item.getStatus().equals("Reported")){
                System.out.println("\n--- Laporan ---");
                System.out.println(item);
                ada = true;
            }
        }
        if (!ada){
            System.out.println("--- Belum ada laporan dengan status 'Reported'.");
        }
    }
}
