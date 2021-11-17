package com.my.entity;



public class Order {
    private int id;
    private String masterLogin;
    private String serviceName;
    private int userId;
    private String  timeSlot;
    private String dateSlot;
    private String  status;

    public Order(int id, String masterLogin,int userId) {
        this.id = id;
        this.masterLogin = masterLogin;
        this.userId = userId;
    }



    @Override
    public String toString() {
        return "Order { Id : " + id +
                " Master Login : " + masterLogin +
                " User Id : " + userId +
                " Service Name : " + serviceName +
                " Time : " + timeSlot +
                " Data : " + dateSlot +" }";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMasterLogin() {
        return masterLogin;
    }

    public void setMasterLogin(String masterLogin) {
        this.masterLogin = masterLogin;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDateSlot() {
        return dateSlot;
    }

    public void setDateSlot(String dateSlot) {
        this.dateSlot = dateSlot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
