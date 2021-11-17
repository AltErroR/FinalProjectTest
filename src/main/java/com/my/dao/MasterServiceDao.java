package com.my.dao;

import com.my.entity.MasterService;

import java.util.List;

public interface MasterServiceDao {
    boolean createMasterService(String masterLogin ,String serviceName);
    boolean updateMasterService(int id,String masterLogin ,String serviceName);
    com.my.entity.MasterService getMasterService(int id);
    boolean deleteMasterService(int id);
    List<MasterService> getAllMasterServices();
    List<MasterService> getAllMasterServicesByName(String query,String name,int offset,int limit);
    List<MasterService> getAllMasterServices(String query,int offset,int limit);
    int getAmmount();
}
