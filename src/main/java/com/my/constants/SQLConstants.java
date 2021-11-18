package com.my.constants;

public class SQLConstants {

    private  SQLConstants(){
        //constructor to make this class have no public constructors
    }

    public static final String INSERT_INTO_ACCOUNT = "INSERT INTO beauty_salon.account (id,login) VALUES (DEFAULT,?)";
    public static final String UPDATE_ACCOUNT ="UPDATE beauty_salon.account SET login = ?, pasword = ?, email = ? WHERE (id = ?)";
    public static final String SELECT_ACCOUNT="SELECT * FROM beauty_salon.account WHERE (id = ?)";
    public static final String SELECT_ACCOUNT_BY_LOGIN ="SELECT * FROM beauty_salon.account WHERE (login = ?)";
    public static final String DELETE_ACCOUNT="DELETE FROM beauty_salon.account WHERE (id = ?)";
    public static final String SELECT_ACCOUNT_ID="SELECT id FROM beauty_salon.account";

    public static final String INSERT_INTO_ADMIN = "INSERT INTO beauty_salon.admin (id) VALUES (?)";
    public static final String SELECT_ADMIN="SELECT * " +
            " FROM beauty_salon.account as ac " +
            " INNER JOIN beauty_salon.admin as ad ON ac.id= ad.id" +
            " WHERE ad.id = ? ";
    public static final String DELETE_ADMIN="DELETE FROM beauty_salon.admin WHERE (id = ?)";
    public static final String SELECT_ADMIN_ID="SELECT id FROM beauty_salon.admin";

    public static final String INSERT_INTO_FEEDBACK ="INSERT INTO beauty_salon.feedback (id,user_id, master_login) VALUES (DEFAULT,?,?)" ;
    public static final String UPDATE_FEEDBACK ="UPDATE beauty_salon.feedback SET user_id = ?, master_login = ?," +
            " feedback = ?,user_rate = ? WHERE (id = ?)";
    public static final String SELECT_FEEDBACK="SELECT * FROM beauty_salon.feedback WHERE (id = ?)";
    public static final String SELECT_FEEDBACK_BY_USER_MASTER="SELECT * FROM beauty_salon.feedback WHERE (user_id = ? and master_login= ?)";
    public static final String DELETE_FEEDBACK="DELETE FROM beauty_salon.feedback WHERE (id = ?)";
    public static final String SELECT_FEEDBACK_ID="SELECT id FROM beauty_salon.feedback";
    public static final String SELECT_FEEDBACK_BY_USER ="SELECT * FROM beauty_salon.order" +
            " where status = 'paid' && feedback_request = '1' && user_id=?";

    public static final String INSERT_INTO_MASTER = "INSERT INTO beauty_salon.master (login) VALUES (?)";
    public static final String UPDATE_MASTER ="UPDATE beauty_salon.master SET status = ?, rating = ? WHERE (login = ?)";
    public static final String SELECT_MASTER="SELECT * " +
            "FROM beauty_salon.account as a " +
            "INNER JOIN beauty_salon.master as m ON a.login = m.login " +
            "WHERE m.login = ? ";
    public static final String DELETE_MASTER="DELETE FROM beauty_salon.master WHERE (login = ?)";
    public static final String SELECT_MASTER_LOGIN="SELECT login FROM beauty_salon.master";

    public static final String INSERT_INTO_ORDER ="INSERT INTO beauty_salon.order (id,user_id, master_login,time_slot,date_slot,service_name) VALUES (DEFAULT,?,?,?,?,?)";
    public static final String UPDATE_ORDER ="UPDATE beauty_salon.order SET user_id = ?, master_login = ?," +
            " service_name = ?,time_slot = ?, date_slot= ?, status= ? WHERE (id = ?)";
    public static final String SELECT_ORDER="SELECT * FROM beauty_salon.order WHERE (id = ?)";
    public static final String SELECT_ORDER_WITHOUT_ID="SELECT * FROM beauty_salon.order WHERE(service_name = ? && time_slot= ? && master_login = ? && date_slot= ?)";
    public static final String DELETE_ORDER="DELETE FROM beauty_salon.order WHERE (id = ?)";
    public static final String SELECT_ORDER_ID="SELECT id FROM beauty_salon.order";
    public static final String SELECT_RESERVED_ORDERS ="SELECT * FROM beauty_salon.order where status = 'reserved'";
        public static final String SELECT_DONE_ORDERS ="SELECT * FROM beauty_salon.order where status = 'done'";

    public static final String SELECT_ORDERS_FOR_USER= "SELECT * From beauty_salon.order " +
            "WHERE date_slot = CURDATE() - 1 and status='paid' and user_id= ?";
    public static final String SELECT_ORDERS_FOR_MASTER= "SELECT * FROM beauty_salon.order \n" +
            " WHERE master_login = ? && date_slot = CURDATE()&& (status = 'reserved'||status = 'in progress')";
//            "SELECT o.* FROM beauty_salon.order as o\n" +
//            " inner join  beauty_salon.account as a on a.id = o.user_id \n" +
//            "             WHERE o.master_login = ? && o.date_slot = CURDATE()";

    public static final String INSERT_INTO_SERVICE = "INSERT INTO beauty_salon.service (name) VALUES (?)";
    public static final String UPDATE_SERVICE ="UPDATE beauty_salon.service SET price = ? WHERE (name = ?)";
    public static final String SELECT_SERVICE="SELECT * FROM beauty_salon.service WHERE (name = ?)";
    public static final String DELETE_SERVICE="DELETE FROM beauty_salon.service WHERE (name = ?)";
    public static final String SELECT_SERVICE_NAME="SELECT name FROM beauty_salon.service";

    public static final String INSERT_INTO_USER ="INSERT INTO beauty_salon.user (id) VALUES (?)" ;
    public static final String UPDATE_USER ="UPDATE beauty_salon.user SET wallet = ? WHERE (id = ?)";
    public static final String SELECT_USER="SELECT * " +
            " FROM beauty_salon.account as a " +
            " INNER JOIN beauty_salon.user as u ON a.id = u.id " +
            " WHERE u.id = ? ";
    public static final String DELETE_USER="DELETE FROM beauty_salon.user WHERE (id = ?)";
    public static final String SELECT_USER_ID="SELECT id FROM beauty_salon.user";

    public static final String INSERT_INTO_MASTER_SERVICES ="INSERT INTO beauty_salon.service_master (id,login_master, name_service) VALUES (DEFAULT,?,?)";
    public static final String UPDATE_MASTER_SERVICES ="UPDATE beauty_salon.service_master SET name_service = ?, login_master= ? WHERE (id =?)";
    public static final String SELECT_MASTER_SERVICES ="SELECT * FROM beauty_salon.service_master WHERE (id = ?)";
    public static final String DELETE_MASTER_SERVICES ="DELETE FROM  beauty_salon.service_master WHERE (id= ?)";
    public static final String SELECT_MASTER_SERVICES_ID ="SELECT id FROM beauty_salon.service_master";
    public static final String COUNT_MASTER_SERVICES = "select count(*) from service_master";
    public static final String SQL_SUBLIST_BY_ID = "SELECT * FROM beauty_salon.service_master ORDER BY id LIMIT ? OFFSET ?";
    public static final String SQL_SUBLIST_BY_MASTER = "SELECT * FROM beauty_salon.service_master ORDER BY login_master LIMIT ? OFFSET ?";
    public static final String SQL_SUBLIST_BY_SERVICE = "SELECT * FROM beauty_salon.service_master ORDER BY name_service LIMIT ? OFFSET ?";

    public static final String SQL_SUBLIST_BY_RATING ="SELECT sm.id,sm.login_master,sm.name_service FROM beauty_salon.service_master as sm " +
            "inner join beauty_salon.master as m on sm.login_master = m.login ORDER BY m.rating*1 LIMIT ? OFFSET ?";
    public static final String SQL_SUBLIST_BY_MASTER_NAME=" SELECT * FROM beauty_salon.service_master " +
            " where login_master = ? LIMIT ? OFFSET ?";
    public static final String SQL_SUBLIST_BY_SERVICE_NAME="SELECT * FROM beauty_salon.service_master " +
            " where name_service = ? LIMIT ? OFFSET ?";

    public static final String SQL_AUTO_GET_YESTERDAY_DATE = "SELECT a.id,login, email, date_slot\n" +
            " From beauty_salon.account as a\n" +
            " INNER JOIN beauty_salon.order as o ON a.id = o.user_id\n" +
            " WHERE o.date_slot = CURDATE() - 1 and o.status='paid'";
}
