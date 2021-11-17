package com.my.entity;

public class Account {
    protected int id;
    protected String login;
    protected String password;
    protected String email;

    public Account(int id, String login) {
        this.id = id;
        this.login = login;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password + " }";
    }
}
