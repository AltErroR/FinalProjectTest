package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.MasterDao;
import com.my.entity.Master;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlMasterDao implements MasterDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlMasterDao.class);

    @Override
    public boolean createMaster(String login) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_MASTER);
            ps.setString(1,login);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("master creation failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateMaster(String login, String status, String rating) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_MASTER);
            ps.setString(1,status);
            ps.setString(2,rating);
            ps.setString(3,login);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("master update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Master getMaster(String login) {
        Master master;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_MASTER);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no master data");
                return null;}
            master= new Master(rs.getInt(1),rs.getString(2));
            master.setPassword(rs.getString(3));
            master.setEmail(rs.getString(4));
            master.setStatus(rs.getString(6));
            master.setRating(rs.getString(7));
        } catch (Exception e) {
            logger.error("master extraction data failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return master;
    }

    @Override
    public boolean deleteMaster(String login) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_MASTER);
            ps.setString(1,login);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("master delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<Master> getAllMasters() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Master> masters= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_MASTER_LOGIN);
            rs = ps.executeQuery();
            while(rs.next()){
                masters.add(getMaster(rs.getString(1)));
            }
        } catch (Exception e) {
            logger.error("extracting master list data failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return masters;
    }
}
