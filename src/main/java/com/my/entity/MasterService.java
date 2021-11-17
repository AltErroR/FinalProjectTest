package com.my.entity;


public class MasterService {
    protected int id;
    protected String masterLogin;
    protected String serviceName;

    public MasterService(String masterLogin,String serviceName){
        this.masterLogin= masterLogin;
        this.serviceName=serviceName;
    }



    @Override
    public String toString() {
        return "MasterServiceDao { Id : " + id +
                " Master Login : " + masterLogin +
                " Service Name : " + serviceName +" }";
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
}
