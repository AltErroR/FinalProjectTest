package com.my.dao.mysql;

import com.my.dao.DBManager;
import com.my.dao.UserDao;
import com.my.entity.Feedback;
import com.my.entity.Master;
import com.my.entity.User;
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

public class MySqlUserDao implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(MySqlUserDao.class);
    @Override
    public boolean createUser(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_USER);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("user create failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateUser(int id, int wallet) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_USER );
            ps.setInt(1,wallet);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("user update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_USER);;
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.error("no user data");
                return null;}
            user= new User(rs.getInt(1),rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setWallet(rs.getInt(6));
        } catch (Exception e) {
            logger.error("user extraction failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_USER);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("user delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<User> users= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_USER_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                users.add(getUser(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("user list extraction failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return users;
    }
}
