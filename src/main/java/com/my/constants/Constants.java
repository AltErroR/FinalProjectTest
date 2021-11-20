package com.my.constants;

public class Constants {

    private  Constants(){
        //constructor to make this class have no public constructors
    }

    public static final String DATE= "date";
    public static final String TIME = "time";
    public static final String MASTER = "master";
    public static final String SERVICE = "service";
    public static final String USER_ID = "userId";
    public static final String SESSION_LANGUAGE = "lang";
    public static final String LANGUAGE = "language";
    public static final String ADMIN_HOME = "adminHomeInit";
    public static final String BOOKING = "booking";
    public static final String CREATION = "creation";
    public static final String ERROR = "error";
    public static final String FEEDBACK = "feedback";
    public static final String WRITE_FEEDBACK = "feedbackWrite";
    public static final String HOME = "home";
    public static final String LOGIN = "login";
    public static final String LOG_OUT = "logout";
    public static final String MAIN = "mainPage";
    public static final String MAIN_MASTER = "mainPageByMaster";
    public static final String MAIN_SERVICE = "mainPageByService";
    public static final String MAIN_RATING = "mainPageByRating";
    public static final String MAIN_MASTER_NAME = "mainPageByMasterLogin";
    public static final String MAIN_SERVICE_NAME = "mainPageByServiceName";
    public static final String MASTER_HOME = "masterHomeInit";
    public static final String ORDERS = "orders";
    public static final String CHANGE_ORDER = "orderChange";
    public static final String PAYMENT = "payment";
    public static final String ACCEPT_PAYMENT = "paymentAccept";
    public static final String CHANGE_STATUS = "statusChange";
    public static final String SUCCESS = "success";
    public static final String CHANGE_LANGUAGE = "changeLanguage";
    public static final String ROLE = "role";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_REPEAT = "password-repeat";
    public static final String EMAIL = "email";
    public static final String USER = "user";
    public static final String WALLET = "wallet";
    public static final String USER_LOGIN = "userLogin";
    public static final String USER_LOGGED_IN = "userLoggedIn";
    public static final String FEEDBACK_LIST = "feedbackList";
    public static final String MESSAGE = "message";
    public static final String RATE = "rate";
    public static final String ADMIN = "admin";
    public static final String MAIL_PROPERTIES = "mail.properties";
    public static final String SALON_EMAIL = "b24963@gmail.com";
    public static final String SALON_NAME = "Romashka&Petrushka Salon";
    public static final String MAIL_MESSAGE = "Leave feedback please for yesterday service";
    public static final String MAIL_PASSWORD = "123456B_o";
    public static final String PAGE = "page";
    public static final String NUMBER_OF_PAGES = "noOfPages";
    public static final String CURRENT_PAGE = "currentPage";
    public static final String SEARCH_LIST = "masterServiceList";
    public static final String SORT_BY = "sortBy";
    public static final String RATING ="rating";
    public static final String MASTER_NAME = "masterName";
    public static final String SERVICE_NAME = "serviceName";
    public static final String ID = "id";
    public static final String ORDER_ID = "orderId";
    public static final String STATUS = "status";
    public static final String DELETE = "delete";
    public static final String UPDATE = "update";
    public static final String PAID = "paid";
    public static final String ORDERS_LIST = "ordersList";
    public static final String BIN = "bin";
    public static final String SRC = "src";
    public static final String LOG4J_PROPERTIES = "log4j2.properties";
    public static final String CONNECTION_CONTEXT ="java:comp/env/jdbc/salon";
    public static final String UTF_8 ="UTF-8";

    public static final String MAIN_JSP = "view/main.jsp";
    public static final String MASTER_HOME_JSP = "view/masterHome.jsp";
    public static final String ADMIN_HOME_JSP = "view/adminHome.jsp";
    public static final String ERROR_JSP = "view/error.jsp";
    public static final String SUCCESS_JSP = "view/success.jsp";
    public static final String WRITE_FEEDBACK_JSP = "view/writeFeedback.jsp";
    public static final String GET_PAYMENT_JSP = "view/getPayment.jsp";
    public static final String FEEDBACK_JSP = "view/feedback.jsp";

    public static final String SUCCESS_JSP_PATH = "/FPT/view/success.jsp";
    public static final String ERROR_JSP_PATH = "/FPT/view/error.jsp";
    public static final String ADMIN_HOME_JSP_PATH = "/FPT/view/adminHome.jsp";
    public static final String FEEDBACK_JSP_PATH = "/FPT/view/feedback.jsp";
    public static final String FOOTER_JSP_PATH = "/FPT/view/footer.jsp";
    public static final String HEADER_JSP_PATH = "/FPT/view/header.jsp";
    public static final String MAIN_JSP_PATH = "/FPT/view/main.jsp";
    public static final String ACCOUNT_CREATION_JSP_PATH = "/FPT/view/accountCreation.jsp";
    public static final String AUTHORIZATION_JSP_PATH = "/FPT/view/authorization.jsp";
    public static final String INDEX_JSP_PATH = "/FPT/index.jsp";
    public static final String FPT = "/FPT/";
    public static final String MASTER_HOME_JSP_PATH = "/FPT/view/masterHome.jsp";
    public static final String BOOKING_JSP_PATH = "/FPT/view/booking.jsp";
    public static final String WRITE_FEEDBACK_JSP_PATH = "/FPT/view/writeFeedback.jsp";

    public static final String LOG_OUT_COMMAND ="/controller?command=mainPage";
    public static final String MAIN_PAGE_COMMAND = "/FPT/controller?command=mainPage";
    public static final String MASTER_HOMEPAGE_COMMAND ="/FPT/controller?command=masterHomeInit";
    public static final String ADMIN_HOMEPAGE_COMMAND ="/FPT/controller?command=adminHomeInit";
    public static final String LOG_OUT_COMMAND_PATH ="/FPT/controller?command=logout";
    public static final String LOGIN_COMMAND ="/FPT/controller?command=login";
    public static final String ERROR_COMMAND ="/FPT/controller?command=error";
    public static final String SUCCESS_COMMAND ="/FPT/controller?command=success";
    public static final String ADMIN_HOME_COMMAND ="/FPT/controller?command=adminHomeInit";
    public static final String ORDER_CHANGE_COMMAND ="/FPT/controller?command=orderChange";
    public static final String SORT1_COMMAND ="/FPT/controller?command=mainPageByMaster";
    public static final String SORT2_COMMAND ="/FPT/controller?command=mainPageByService";
    public static final String SORT3_COMMAND ="/FPT/controller?command=mainPageByRating";
    public static final String SORT4_COMMAND ="/FPT/controller?command=mainPageByMasterLogin";
    public static final String SORT5_COMMAND ="/FPT/controller?command=mainPageByServiceName";
    public static final String ACCEPT_PAYMENT_COMMAND ="/FPT/controller?command=paymentAccept";
    public static final String PAYMENT_COMMAND ="/FPT/controller?command=payment";
    public static final String FEEDBACK_COMMAND ="/FPT/controller?command=feedback";
    public static final String CHANGE_LANGUAGE_COMMAND ="/FPT/controller?command=changeLanguage";
    public static final String CREATION_COMMAND ="/FPT/controller?command=creation";
    public static final String MASTER_HOME_COMMAND ="/FPT/controller?command=masterHomeInit";
    public static final String STATUS_CHANGE_COMMAND ="/FPT/controller?command=statusChange";
    public static final String FEEDBACK_WRITE_COMMAND ="/FPT/controller?command=feedbackWrite";
    public static final String ORDERS_COMMAND ="/FPT/controller?command=orders";
    public static final String BOOKING_COMMAND ="/FPT/controller?command=booking";






}
