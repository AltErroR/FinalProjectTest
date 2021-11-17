package com.my.dao;

import com.my.entity.Account;

import java.util.List;

public interface AccountDao {
    boolean createAccount( String login);
    boolean updateAccount(int id,String login,String password,String mail);
    Account getAccount(int id);
    Account getAccount(String login);
    boolean deleteAccount(int id);
    List<Account> getAllAccounts();
    List<String> getAllMails();
}
