package com.my.entity;


public class Master extends Account {
    protected String status;
    protected String rating;

    public Master(int id,String login) {
        super(id,login);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Master { Id : " + id +
                " Email : " + email +
                " Login : " + login +
                " Password : " + password +
                " Status : " + status +
                " Rating : " + rating + " }";
    }
}
