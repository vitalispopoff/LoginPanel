package user;

public class User {

//    private int id;
    private String login;
    private String pass;
    private String gender;
    private String info;

    public User(String login, String pass, String gender, String info) {
        this.login = login;
        this.pass = pass;
        this.gender = gender;
        this.info = info;
    }
}
