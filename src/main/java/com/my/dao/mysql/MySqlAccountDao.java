package com.my.dao.mysql;

import com.my.dao.AccountDao;
import com.my.dao.DBManager;
import com.my.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.my.constants.SQLConstants.*;

public class MySqlAccountDao implements AccountDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlAccountDao.class);

    @Override
    public boolean createAccount(String login) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(INSERT_INTO_ACCOUNT);
            ps.setString(1,login);
            ps.executeUpdate();
        } catch (Exception e) {
           logger.error("account creation failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public boolean updateAccount(int id, String login, String password, String email) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(UPDATE_ACCOUNT);
            ps.setString(1,login);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setInt(4,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("account update failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public Account getAccount(int id) {
        Account account;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ACCOUNT);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            account= new Account(rs.getInt(1),rs.getString(2));
            account.setPassword(rs.getString(3));
            account.setEmail(rs.getString(4));

        } catch (Exception e) {
            logger.error("account data extraction from bd failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return account;
    }

    @Override
    public Account getAccount(String login) {
        Account account;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ACCOUNT_BY_LOGIN);
            ps.setString(1, login);
            rs = ps.executeQuery();
            if (!rs.next()){
                logger.warn("no account found");
                return null;}
            account= new Account(rs.getInt(1),rs.getString(2));
            account.setPassword(rs.getString(3));
            account.setEmail(rs.getString(4));

        } catch (Exception e) {
            logger.error("extraction account data failed");
            throw new RuntimeException(e.getMessage());
        } finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return account;
    }

    @Override
    public boolean deleteAccount(int id) {
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(DELETE_ACCOUNT);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (Exception e) {
            logger.error("account delete failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(ps);
            DBManager.close(connection);
        }
        return true;
    }

    @Override
    public List<Account> getAllAccounts() {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<Account> admins= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SELECT_ACCOUNT_ID);
            rs = ps.executeQuery();
            while(rs.next()){
                admins.add(getAccount(rs.getInt(1)));
            }
        } catch (Exception e) {
            logger.error("failed to get list of accounts");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return admins;
    }
    @Override
    public List<String> getAllMails(){
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        List<String> mails= new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            ps = connection.prepareStatement(SQL_AUTO_GET_YESTERDAY_DATE);
            rs = ps.executeQuery();
            while(rs.next()){
                mails.add(rs.getString(3));
            }
        } catch (Exception e) {
            logger.error("mails extraction failed");
            throw new RuntimeException(e.getMessage());
        }
        finally {
            DBManager.close(rs);
            DBManager.close(ps);
            DBManager.close(connection);
        }

        return mails;
    }
}
