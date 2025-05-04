public abstract class User
{
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    public void displayinfo()
    {
        System.out.println("NAMA    :"+nama);
        System.out.println("NIM    :"+nim);
    }
    public boolean login(){
        return false;
    };
}
