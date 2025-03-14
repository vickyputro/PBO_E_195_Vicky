class RekeningBank {
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // Constructor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
    }

    // Method untuk menyetor uang
    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println(namaPemilik + " menyetor " + jumlah + " saldo sekarang: " + saldo);
        } else {
            System.out.println("Jumlah setor harus lebih dari 0.");
        }
    }

    // Method untuk menarik uang
    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik " + jumlah + " (Berhasil) Saldo sekarang: " + saldo);
        } else {
            System.out.println(namaPemilik + " menarik " + jumlah + " (Gagal, saldo tidak mencukupi) Saldo saat ini: " + saldo);
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        // Membuat dua objek RekeningBank
        RekeningBank rekening1 = new RekeningBank("202410370110195", "Vicky Leo Cahyo Putro", 1000000.0);
        RekeningBank rekening2 = new RekeningBank("202410370110221", "Andika Mulya Febriyanto", 500000.0);

        // Menampilkan informasi rekening
        System.out.println();
        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();

        // Menyetor uang ke rekening
        System.out.println();
        rekening1.setorUang(200000.0);
        rekening2.setorUang(150000.0);

        // Menarik uang dari rekening2
        System.out.println();
        rekening1.tarikUang(150000.0);
        rekening2.tarikUang(700000.0);

        // Menampilkan informasi rekening setelah setor dan tarik
        System.out.println();
        rekening1.tampilkanInfo();
        System.out.println();
        rekening2.tampilkanInfo();
    }
}
