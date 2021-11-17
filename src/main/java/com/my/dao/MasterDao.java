package com.my.dao;


import com.my.entity.Master;

import java.util.List;

public interface MasterDao {
    boolean createMaster(String login);
    boolean updateMaster(String login,String status,String rating);
    Master getMaster(String login);
    boolean deleteMaster(String login);
    List<Master> getAllMasters();
}
