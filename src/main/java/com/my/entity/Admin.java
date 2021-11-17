package com.my.entity;

public class Admin extends Account {


    public Admin(int id,String login){
    super(id,login);
    }
    @Override
    public String toString() {
        return "Admin { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password + " }";
    }
}
