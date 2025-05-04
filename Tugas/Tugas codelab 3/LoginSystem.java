import java.util.Scanner;
public class LoginSystem
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistem Login ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        User user = null;
        switch (pilihan) {
            case 1:
                System.out.print("Masukkan nama: ");
                String namaAdmin = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nimAdmin = scanner.nextLine();
                System.out.print("Masukkan username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();

                user = new Admin(namaAdmin, nimAdmin, username, password);
                break;

            case 2:
                System.out.print("Masukkan nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                user = new Mahasiswa(nama, nim);
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                scanner.close();
                return;
        }

        if (user.login()) {
            user.displayinfo();
        } else {
            System.out.println("Login gagal. Cek kembali data Anda.");
        }

        scanner.close();
    }
}