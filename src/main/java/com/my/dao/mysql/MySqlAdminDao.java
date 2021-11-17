package com.my.dao.mysql;

import com.my.dao.AdminDao;
import com.my.dao.DBManager;
import com.my.entity.Admin;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlAdminDao implements AdminDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlAdminDao.class);

    @Override
    public boolean createAdmin(int id){
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_ADMIN);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("admin creation failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
        DBManager.close(ps);
        DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Admin getAdmin(int id) {
        Admin admin = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ADMIN);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no admin data");
                return null;}
            admin= new Admin(rs.getInt(1),rs.getString(2));
            admin.setPassword(rs.getString(3));
            admin.setEmail(rs.getString(4));
        } catch (Exception e) {
            logger.error("admin extraction data failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return admin;
    }

    @Override
    public boolean deleteAdmin(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_ADMIN);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("admin delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<Admin> getAllAdmins() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Admin> admins= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ADMIN_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                admins.add(getAdmin(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("extracting admin list from bd failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return admins;
    }
}
