package user;

public class User {

    private String login;
    private String pass;
    private String gender;
    private String info;
    private boolean language_0;
    private boolean language_1;
    private boolean language_2;

    public User(
            String login,
            String pass,
            String gender,
            boolean language_0,
            boolean language_1,
            boolean language_2,
            String info
    ) {
        this.login = login;
        this.pass = pass;
        this.gender = gender;
        this.language_0 = language_0;
        this.language_1 = language_1;
        this.language_2 = language_2;
        this.info = info;
    }
}
