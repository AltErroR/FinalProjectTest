package com.my.entity;

public class User extends Account {
    protected int wallet;

    public User(int id,String login) {
        super(id,login);
    }

    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }



    @Override
    public String toString() {
        return "User { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password +
                " Salary : " + wallet + " }";
    }
}
