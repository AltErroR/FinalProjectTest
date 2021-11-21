package com.my.controller.service.implementation;

import com.my.controller.service.LoginService;
import com.my.dao.*;
import com.my.dao.mysql.*;
import com.my.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

import static com.my.constants.Constants.*;

public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    AccountDao mySqlAccountDao= daoFactory.getAccountDao();
    AdminDao mySqlAdminDao= daoFactory.getAdminDao();
    MasterDao mySqlMasterDao= daoFactory.getMasterDao();
    UserDao mySqlUserDao= daoFactory.getUserDao();
    @Override
    public String login( HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        String login= request.getParameter(LOGIN);
        String password= request.getParameter(PASSWORD);
        String role= request.getParameter(ROLE);
        Account account = mySqlAccountDao.getAccount(login);
        if(account==null||!Objects.equals(password, account.getPassword())){
            logger.warn("login failed");
            throw new Exception("Bad credentials for entered user data during authorization");
        }

            if (USER.equals(role) && mySqlUserDao.getUser(account.getId()) != null) {
                session = request.getSession();
                session.setAttribute(WALLET,mySqlUserDao.getUser(account.getId()).getWallet());
                initSession(session, role, account);
                logger.debug("user logged in");
                return MAIN_PAGE_COMMAND;
            }
            if (MASTER.equals(role) && mySqlMasterDao.getMaster(account.getLogin()) != null) {
                session = request.getSession();
                initSession(session, role, account);
                logger.debug("master logged in");
                return MASTER_HOMEPAGE_COMMAND;
            }
            if (mySqlAdminDao.getAdmin(account.getId()) == null) {
                logger.warn("log in failed(wrong role)");
                session.invalidate();
                throw new Exception("Your data is as invalid as you");
            }
        session = request.getSession();
        initSession(session, ADMIN, account);
        logger.debug("admin logged in");
        return ADMIN_HOMEPAGE_COMMAND;
    }

    private void initSession(HttpSession session, String role, Account account) {
        session.setMaxInactiveInterval(300);
        session.setAttribute(ROLE, role);
        session.setAttribute(USER_ID, account.getId());
        session.setAttribute(USER_LOGIN, account.getLogin());
        session.setAttribute(USER_LOGGED_IN, true);
    }
}
