package com.my.controller.service.imlementation;

import com.my.controller.Controller;
import com.my.controller.service.AccountCreationService;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlMasterDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Account;
import com.my.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AccountCreationServiceImpl implements AccountCreationService {
    private static final Logger logger = LoggerFactory.getLogger(AccountCreationServiceImpl.class);
        MySqlAccountDao mySqlAccountDao= new MySqlAccountDao();
    MySqlUserDao mySqlUserDao= new MySqlUserDao();
    MySqlMasterDao mySqlMasterDao= new MySqlMasterDao();
        @Override
        public String creation(HttpServletRequest request, HttpServletResponse response) throws Exception {
            logger.debug("account creation");
            HttpSession session =  request.getSession(false);
            if(session!=null){session.invalidate();
                logger.debug("session invalidation");}
            String login= request.getParameter("login");
            String password=request.getParameter("password");
            String passwordRepeat=request.getParameter("password-repeat");
            String email=request.getParameter("email");
            String role= request.getParameter("role");
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
            if ("user".equals(role)) {
                logger.debug("role - user");
                session = request.getSession();
                mySqlUserDao.createUser(account.getId());
                User u =mySqlUserDao.getUser(account.getId());
                        initSession(session, account, "user");
                session.setAttribute("wallet",u.getWallet());
                return "view/main.jsp";
            }
            if ("master".equals(role)) {
                logger.debug("role - master");
                session = request.getSession();
                mySqlMasterDao.createMaster(account.getLogin());
                initSession(session, account, "master");
                return "view/masterHome.jsp";
            }
            logger.warn("some strange happen, redirect on error.jsp");
            return "view/error.jsp";
        }

    private void initSession(HttpSession session, Account account, String role) {
        session.setAttribute("role", role);
        session.setAttribute("userId", account.getId());
        session.setAttribute("userLogin", account.getLogin());
        session.setAttribute("userLoggedIn", true);
    }
}

