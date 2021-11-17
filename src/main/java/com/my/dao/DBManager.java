package com.my.dao;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private static final Logger logger = LoggerFactory.getLogger(DBManager.class.getName());

    private static DataSource ds;
    private static DBManager instance;

    private DBManager() {}

    public static synchronized DBManager getInstance(){
        if(instance==null){
            instance= new DBManager();
        }
        return instance;
    }

    public static Connection getConnection() throws SQLException, NamingException {
        if(ds == null) {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup("java:comp/env/jdbc/salon");
        }
        return ds.getConnection();
    }

    public static void close(AutoCloseable ac) {
        if (ac != null) {
            try{
                ac.close();
            }
            catch (Exception e){
                logger.error("close resource failed");
                throw new RuntimeException(e.getMessage());
            }

        }
    }

    public static void rollback(Connection con) throws SQLException {
        if (con != null) {
            con.rollback();
        }
    }

}
