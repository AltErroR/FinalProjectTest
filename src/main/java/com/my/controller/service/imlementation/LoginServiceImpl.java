package com.my.controller.service.imlementation;

import com.my.controller.Controller;
import com.my.controller.command.LoginCommand;
import com.my.controller.service.LoginService;
import com.my.dao.mysql.MySqlAccountDao;
import com.my.dao.mysql.MySqlAdminDao;
import com.my.dao.mysql.MySqlMasterDao;
import com.my.dao.mysql.MySqlUserDao;
import com.my.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class LoginServiceImpl implements LoginService {
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
    MySqlAccountDao mySqlAccountDao= new MySqlAccountDao();
    MySqlAdminDao mySqlAdminDao= new MySqlAdminDao();
    MySqlMasterDao mySqlMasterDao= new MySqlMasterDao();
    MySqlUserDao mySqlUserDao= new MySqlUserDao();
    @Override
    public String login( HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        String login= request.getParameter("login");
        String password= request.getParameter("password");
        String role= request.getParameter("role");
        Account account = mySqlAccountDao.getAccount(login);
        if(account==null||!Objects.equals(password, account.getPassword())){
            logger.warn("login failed");
            throw new Exception("Bad credentials for entered user data during authorization");
        }

            if ("user".equals(role) && mySqlUserDao.getUser(account.getId()) != null) {
                session = request.getSession();
                session.setAttribute("wallet",mySqlUserDao.getUser(account.getId()).getWallet());
                initSession(session, role, account);
                logger.debug("user logged in");
                return "/FPT/controller?command=mainPage";
            }
            if ("master".equals(role) && mySqlMasterDao.getMaster(account.getLogin()) != null) {
                session = request.getSession();
                initSession(session, role, account);
                logger.debug("master logged in");
                return "/FPT/controller?command=masterHomeInit";
            }
            if (mySqlAdminDao.getAdmin(account.getId()) == null) {
                logger.warn("log in failed(wrong role)");
                session.invalidate();
                throw new Exception("Your data is as invalid as you");
            }
        session = request.getSession();
        initSession(session, "admin", account);
        logger.debug("admin logged in");
        return "/FPT/controller?command=adminHomeInit";
    }

    private void initSession(HttpSession session, String role, Account account) {
        session.setMaxInactiveInterval(300);
        session.setAttribute("role", role);
        session.setAttribute("userId", account.getId());
        session.setAttribute("userLogin", account.getLogin());
        session.setAttribute("userLoggedIn", true);
    }
}
