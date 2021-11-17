package com.my.dao;

import com.my.entity.Account;
import com.my.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    boolean createAdmin(int id);
    Admin getAdmin(int id);
    boolean deleteAdmin(int id);
    List<Admin> getAllAdmins();
}
