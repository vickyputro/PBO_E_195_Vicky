import java.util.Scanner;
public class LoginSystem
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();
        System.out.println("=== Login Menu ===");
        System.out.println("1. Admin ");
        System.out.println("2. Mahasiswa ");
        System.out.print("Pilih login (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan){
            case 1:
                //INPUT
                System.out.print("Masukkan Username admin:");
                String username = scanner.nextLine();
                System.out.print("Masukkan password admin:");
                String password = scanner.nextLine();
                //Kondisi dimana menggunaka nilai pada boolean
                if (admin.login(username, password)) {
                    System.out.println("login berhasil.");
                }else {
                    System.out.println("error");
                }
                break;
            case 2:
                //INPUT
                System.out.print("Masukkan Nama :");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM  :");
                String nim = scanner.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    System.out.println("login berhasil.");
                    System.out.println();
                    mahasiswa.displayinfo();
                }else{
                    System.out.println("error");
                }

                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
        scanner.close();
    }
}