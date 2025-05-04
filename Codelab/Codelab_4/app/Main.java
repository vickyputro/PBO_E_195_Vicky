package app;
import perpustakaan.*;
public class Main
{
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu");

        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        Anggota anggota1 = new Anggota("Vicky Leo Cahyo Putro", "E195");
        Anggota anggota2 = new Anggota("Andika Mulya Febriyanto", "E221");

        System.out.println("Anggota: " + anggota1.getNama() + " (ID: " + anggota1.getIdAnggota() + ")");
        System.out.println("Anggota: " + anggota2.getNama() + " (ID: " + anggota2.getIdAnggota() + ")");

        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println();

        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}
