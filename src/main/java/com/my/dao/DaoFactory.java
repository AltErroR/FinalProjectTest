package com.my.dao;


public abstract class DaoFactory {
    private static String daofactoryFCN;
    private static DaoFactory instance;


    public static  synchronized DaoFactory getInstance() throws Exception {
        if(instance==null){
            Class<?> clazz = Class.forName(DaoFactory.daofactoryFCN);
        instance= (DaoFactory) clazz.getDeclaredConstructor().newInstance();
        }
        return  instance;
    }
   protected DaoFactory(){}

   public static void setDaofactoryFCN(String daofactoryFCN){
        instance=null;
        DaoFactory.daofactoryFCN=daofactoryFCN;
   }

   public abstract UserDao getUserDao();
    public abstract AdminDao getAdminDao();
    public abstract AccountDao getAccountDao();
    public abstract FeedbackDao getFeedbackDao();
    public abstract MasterDao getMasterDao();
    public abstract OrderDao getOrderDao();
    public abstract ServiceDao getServiceDao();
    public abstract MasterServiceDao getMasterServiceDao();

}
