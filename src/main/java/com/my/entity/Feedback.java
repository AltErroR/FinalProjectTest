package com.my.entity;

public class Feedback {
    private int id;
    private int userId;
    private String masterLogin;
    private String feedbackMessage;
    private String userRate;

    public Feedback(int id, int userId, String masterLogin) {
        this.id = id;
        this.userId = userId;
        this.masterLogin = masterLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterId) {
        this.masterLogin = masterId;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedback) {
        this.feedbackMessage = feedback;
    }

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }

    @Override
    public String toString() {
        return "Feedback { Id : " + id +
                " Master Login : " + masterLogin +
                " User id : " + userId +
                " Feedback : " + feedbackMessage +
                " User rate : " + userRate + " }";
    }
}
