public class Admin extends User
{
    private String username ;
    private String password ;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }
    @Override
    public boolean login(){
        return username.equals("admin195") && password.equals("password195");
    }
    @Override
    public void displayinfo(){
        System.out.println("Login Admin Berhasil");
        super.displayinfo();
    }
}
