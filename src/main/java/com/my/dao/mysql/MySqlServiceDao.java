package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.ServiceDao;
import com.my.entity.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlServiceDao implements ServiceDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlServiceDao.class);
    @Override
    public boolean createService( String name) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_SERVICE);
            ps.setString(1,name);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("service create failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateService( String name, int price) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_SERVICE);
            ps.setFloat(1,price);
            ps.setString(2,name);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("service update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Service getService(String name) {
        Service service;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_SERVICE);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no service data");
                return null;}
            service= new Service(rs.getString(1));
            service.setPrice(rs.getInt(2));
        } catch (Exception e) {
            logger.error("service data extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return service;
    }

    @Override
    public boolean deleteService(String name) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_SERVICE);
            ps.setString(1,name);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("service delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<Service> getAllServices() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Service> services= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_SERVICE_NAME);
            rs = ps.executeQuery();
            while(rs.next()){
                services.add(getService(rs.getString(1)));
            }
        } catch (Exception e) {
            logger.error("service list extraction failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return services;
    }
}
