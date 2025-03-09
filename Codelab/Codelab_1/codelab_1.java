import java.util.Scanner;
import java.time.Year;

public class codelab_1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input data dari pengguna
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();

        char jenisKelamin;
        while (true) {
            System.out.print("Masukkan jenis kelamin (P/L): ");
            jenisKelamin = sc.next().toUpperCase().charAt(0);

            if (jenisKelamin == 'L' || jenisKelamin == 'P') {
                break; // Keluar dari loop jika input valid
            }else if (jenisKelamin == 'l' || jenisKelamin == 'p') {
                break;
            }
            System.out.println("Input tidak valid! Harap masukkan 'P' untuk Perempuan atau 'L' untuk Laki-laki.");
        }

        System.out.print("Masukkan tahun lahir: ");
        int tahunLahir = sc.nextInt();

        // Menentukan jenis kelamin dalam teks
        String jenisKelaminText = (jenisKelamin == 'L' || jenisKelamin == 'l') ? "Laki-laki" : "Perempuan";

        // Menghitung umur berdasarkan tahun saat ini (2025)
        int tahunSekarang = Year.now().getValue();
        int umur = tahunSekarang - tahunLahir;

        // Menampilkan hasil
        System.out.println("\nData Diri:");
        System.out.println("Nama          : " + nama);
        System.out.println("Jenis Kelamin : " + jenisKelaminText);
        System.out.println("Umur          : " + umur + " tahun");

        sc.close();
    }
}


