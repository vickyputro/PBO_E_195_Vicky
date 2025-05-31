package com.praktikum.main;

import com.praktikum.data.Item;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;

import java.util.Scanner;
import java.util.ArrayList;

public class LoginSystem
{
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItem = new ArrayList<>();
    public static void main(String[] args)
    {
        userList.add(new Admin("Vicky Leo Cahyo Putro","202410370110195","admin195", "password195"));
        userList.add(new Mahasiswa("Vicky Leo Cahyo Putro", "202410370110195"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Sistem Login ---");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan == 1) {
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    boolean loginBerhasil = false;
                    for (User u : userList) {
                        if (u instanceof Admin && u.login(username, password)) {
                            u.displayinfo();
                            u.displayAppMenu();
                            loginBerhasil = true;
                        }
                    }
                    if (!loginBerhasil) {
                        System.out.println("Login Admin gagal: Username atau password salah.");
                    }
                } else if (pilihan == 2) {
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();
                    boolean loginBerhasil = false;
                    for (User u : userList) {
                        if (u instanceof Mahasiswa && u.login(nama, nim)) {
                            u.displayinfo();
                            u.displayAppMenu();
                            loginBerhasil = true;
                        }
                    }
                    if (!loginBerhasil) {
                        System.out.println("Login Mahasiswa gagal: nama atau nim salah.");
                    }
                } else if (pilihan == 0) {
                    System.out.println("Terima kasih!");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid atau data tidak ada.");
                scanner.nextLine();
            }
        }
    }
}