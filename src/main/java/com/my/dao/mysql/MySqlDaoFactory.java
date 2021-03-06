package com.my.dao.mysql;

import com.my.dao.*;

public class MySqlDaoFactory implements DaoFactory {

    MySqlUserDao mySqlUserDaoInstance;
    MySqlAdminDao mySqlAdminDaoInstance;
    MySqlMasterDao mySqlMasterDaoInstance;
    MySqlAccountDao mySqlAccountDaoInstance;
    MySqlFeedbackDao mySqlFeedbackDaoInstance;
    MySqlOrderDao mySqlOrderDaoInstance;
    MySqlServiceDao mySqlServiceDaoInstance;
    MySqlMasterServiceDao mySqlMasterServiceDaoInstance;

    @Override
    public UserDao getUserDao() {
        if(mySqlUserDaoInstance==null)
            mySqlUserDaoInstance= new MySqlUserDao();
        return mySqlUserDaoInstance;
    }

    @Override
    public AdminDao getAdminDao() {
        if(mySqlAdminDaoInstance==null)
            mySqlAdminDaoInstance= new MySqlAdminDao();
        return mySqlAdminDaoInstance;
    }

    @Override
    public AccountDao getAccountDao() {
        if(mySqlAccountDaoInstance==null)
            mySqlAccountDaoInstance= new MySqlAccountDao();
        return mySqlAccountDaoInstance;
    }

    @Override
    public FeedbackDao getFeedbackDao() {
        if(mySqlFeedbackDaoInstance==null)
            mySqlFeedbackDaoInstance= new MySqlFeedbackDao();
        return mySqlFeedbackDaoInstance;
    }

    @Override
    public MasterDao getMasterDao() {
        if(mySqlMasterDaoInstance==null)
            mySqlMasterDaoInstance= new MySqlMasterDao();
        return mySqlMasterDaoInstance;
    }

    @Override
    public OrderDao getOrderDao() {
        if(mySqlOrderDaoInstance==null)
            mySqlOrderDaoInstance= new MySqlOrderDao();
        return mySqlOrderDaoInstance;
    }

    @Override
    public ServiceDao getServiceDao() {
        if(mySqlServiceDaoInstance==null)
            mySqlServiceDaoInstance= new MySqlServiceDao();
        return mySqlServiceDaoInstance;
    }
    @Override
    public MasterServiceDao getMasterServiceDao() {
        if(mySqlMasterServiceDaoInstance==null)
            mySqlMasterServiceDaoInstance= new MySqlMasterServiceDao();
        return mySqlMasterServiceDaoInstance;
    }
}
