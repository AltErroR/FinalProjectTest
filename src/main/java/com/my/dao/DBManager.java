package com.my.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static com.my.constants.Constants.CONNECTION_CONTEXT;

public class DBManager {
    private static final Logger logger = LoggerFactory.getLogger(DBManager.class.getName());

    private static DataSource ds;
//    private static DBManager instance;
//    public static synchronized DBManager getInstance(){
//        if(instance==null){
//            instance= new DBManager();
//        }
//        return instance;
//    }

    private DBManager() {}

    public static Connection getConnection() throws SQLException, NamingException {
        if(ds == null) {
                Context context = new InitialContext();
                ds = (DataSource) context.lookup(CONNECTION_CONTEXT);
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

}
