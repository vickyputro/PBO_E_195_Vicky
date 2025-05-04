class Mahasiswa
{
    private String nama = "Vicky";
    private String nim = "202410370110195";
    //memvalidasi nilai
    public boolean login(String inputnama, String inputnim){
        return inputnama.equals(nama) && inputnim.equals(nim);
    }

    public void displayinfo(){
        System.out.println("Informasi Mahasiswa:");
        System.out.println("Nama    : Vicky Leo Cahyo Putro");
        System.out.println("NIM     : 202410370110195");
    }
}