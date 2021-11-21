package com.my.controller.service.implementation;

import com.my.controller.service.AccountCreationService;
import com.my.dao.AccountDao;
import com.my.dao.DaoFactory;
import com.my.dao.MasterDao;
import com.my.dao.UserDao;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlDaoFactory;
import com.my.dao.mysql.MySqlMasterDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Account;
import com.my.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;

import static com.my.constants.Constants.*;


public class AccountCreationServiceImpl implements AccountCreationService {
    private static final Logger logger = LoggerFactory.getLogger(AccountCreationServiceImpl.class);
    DaoFactory daoFactory= new MySqlDaoFactory();
    AccountDao mySqlAccountDao= daoFactory.getAccountDao();
    UserDao mySqlUserDao= daoFactory.getUserDao();
    MasterDao mySqlMasterDao= daoFactory.getMasterDao();
        @Override
        public String creation(HttpServletRequest request, HttpServletResponse response) throws Exception {
            logger.debug("account creation");
            HttpSession session =  request.getSession(false);
            if (session != null) {
                session.invalidate();
                logger.debug("session invalidation");
            }
            String login= request.getParameter(LOGIN);
            String password=request.getParameter(PASSWORD);
            String passwordRepeat=request.getParameter(PASSWORD_REPEAT);
            String email=request.getParameter(EMAIL);
            String role= request.getParameter(ROLE);
            Account account = mySqlAccountDao.getAccount(login);
            if(account!=null|| !password.equals(passwordRepeat)){
                logger.warn("wrong input or account exist");
                throw new Exception("Bad credentials for entered user data during account creation");
            }

            mySqlAccountDao.createAccount(login);
            account = mySqlAccountDao.getAccount(login);
            account.setPassword(password);
            account.setEmail(email);
            mySqlAccountDao.updateAccount(account.getId(), login, password, email);
            if (USER.equals(role)) {
                logger.debug("role - user");
                session = request.getSession();
                mySqlUserDao.createUser(account.getId());
                User u =mySqlUserDao.getUser(account.getId());
                        initSession(session, account, USER);
                session.setAttribute(WALLET,u.getWallet());
                return MAIN_JSP;
            }
            if (MASTER.equals(role)) {
                logger.debug("role - master");
                session = request.getSession();
                mySqlMasterDao.createMaster(account.getLogin());
                initSession(session, account, MASTER);
                return MASTER_HOME_JSP;
            }
            logger.warn("some strange happened, redirect on error.jsp");
            return ERROR_JSP;
        }

    private void initSession(HttpSession session, Account account, String role) {
        session.setAttribute(ROLE, role);
        session.setAttribute(USER_ID, account.getId());
        session.setAttribute(USER_LOGIN, account.getLogin());
        session.setAttribute(USER_LOGGED_IN, true);
    }
}

