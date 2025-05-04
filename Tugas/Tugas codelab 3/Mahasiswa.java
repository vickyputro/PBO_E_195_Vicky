public class Mahasiswa extends User
{
    public Mahasiswa(String nama,String nim)
    {
        super(nama, nim);
    }

    @Override
    public boolean login() {
        return getNama().equalsIgnoreCase("Vicky Leo Cahyo Putro") && getNim().equals("202410370110195");
    }

    @Override
    public void displayinfo() {
        System.out.println("Login Mahasiswa Berhasil");
        super.displayinfo();
    }
}
