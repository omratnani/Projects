public class Self extends Information{

    private String email;
    private String password;

    public Self(String name,String email,String password ) {
        super.Name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return Name;
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
