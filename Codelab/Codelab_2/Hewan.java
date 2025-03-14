class infoHewan
{
    String nama;
    String jenis;
    String suara;

    public void tampilkanInfo()
    {
        System.out.println("Nama: "+nama);
        System.out.println("Jenis: "+jenis);
        System.out.println("Suara: "+suara);
    }
}
public class Hewan {
    public static void main(String[] args)
    {
        infoHewan hewan1 = new infoHewan();
        infoHewan hewan2 = new infoHewan();

        //Hewan 1
        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";

        //Hewan 2
        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-Woof!!";

        //Tampilan
        hewan1.tampilkanInfo();
        System.out.println();
        hewan2.tampilkanInfo();
    }
}
