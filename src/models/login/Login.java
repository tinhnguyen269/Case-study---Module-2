package models.login;

public class Login {
    private String userName;
    private String passWord;

    public Login(String userName, String passWord) {
        this.passWord = passWord;
        this.userName = userName;
    }

    public Login() {
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
