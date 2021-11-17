package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.MasterServiceDao;
import com.my.entity.MasterService;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlMasterServiceDao implements MasterServiceDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlMasterServiceDao.class);
    @Override
    public boolean createMasterService(String masterLogin ,String serviceName) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_MASTER_SERVICES);
            ps.setString(1,masterLogin);
            ps.setString(2, serviceName);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("create master-service failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateMasterService(int id,String masterLogin ,String serviceName) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_MASTER_SERVICES);
            ps.setString(1,serviceName);
            ps.setString(2,masterLogin);
            ps.setInt(3,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("update master-service failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public MasterService getMasterService(int id) {
        MasterService masterService = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_MASTER_SERVICES);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no master-service data");
                return null;}
            masterService= new MasterService(rs.getString( 2),rs.getString(3));
            masterService.setId(rs.getInt(1));
        } catch (Exception e) {
            logger.error("data extraction for master-service failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return masterService;
    }

    @Override
    public boolean deleteMasterService(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_MASTER_SERVICES);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("delete master-service failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<MasterService> getAllMasterServices() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<MasterService> masterServices = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_MASTER_SERVICES_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                masterServices.add(getMasterService(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error(" extraction list master-service failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return masterServices;
    }
    @Override
    public List<MasterService> getAllMasterServices(String query,int offset,int limit) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<MasterService> masterServices = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1,limit);
            ps.setInt(2,offset);
            rs = ps.executeQuery();
            while(rs.next()){
                masterServices.add(getMasterService(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("get data for pagination failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return masterServices;
    }

    @Override
    public List<MasterService> getAllMasterServicesByName(String query,String name,int offset,int limit) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<MasterService> masterServices = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,limit);
            ps.setInt(3,offset);
            rs = ps.executeQuery();
            while(rs.next()){
                masterServices.add(getMasterService(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("get data for pagination failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return masterServices;
    }


    @Override
    public int getAmmount() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        int ammount=0;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_MASTER_SERVICES_ID);
            rs = ps.executeQuery();
            while(rs.next()){
               ammount++;
            }
        } catch (Exception e) {
            logger.error("count row failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return ammount;
    }

}
