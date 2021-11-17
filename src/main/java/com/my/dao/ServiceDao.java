package com.my.dao;

import com.my.entity.Service;

import java.util.List;

public interface ServiceDao {
    boolean createService(String name);
    boolean updateService(String name,int price);
    Service getService(String name);
    boolean deleteService(String name);
    List<Service> getAllServices();
}
