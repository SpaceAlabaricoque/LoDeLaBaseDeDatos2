package com.example.lodelabasededatos2.db.db;

public class UserData {
    private String userName;
    private String userSurName;
    private String password;
    private String conPassword;
    private String eMail;

    public UserData(String userName, String userSurName, String password, String conPassword, String eMail) {
        this.userName = userName;
        this.userSurName = userSurName;
        this.password = password;
        this.conPassword = conPassword;
        this.eMail = eMail;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurName() {
        return userSurName;
    }

    public void setUserSurName(String userSurName) {
        this.userSurName = userSurName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConPassword() {
        return conPassword;
    }

    public void setConPassword(String conPassword) {
        this.conPassword = conPassword;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
