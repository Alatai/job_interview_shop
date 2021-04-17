package com.saihou.service;

import com.saihou.entity.Account;

import java.util.List;

/**
 * @author Saihou
 * @version 1.0
 * @date 2021/04/17 21:31
 */
public interface AccountService {

    List<Account> findAll();

    void insert(Account account);
}
