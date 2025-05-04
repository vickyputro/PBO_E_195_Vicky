class Admin {
    private String username = "admin195";
    private String password = "password195";
    //memvalidasi nilai
    public boolean login(String inputusername, String inputpassword) {
        return inputpassword.equals(password) && inputusername.equals(username);
    }
}
