package com.saihou.mapper;

import com.saihou.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Saihou
 * @version 1.0
 * @date 2021/04/17 21:31
 */
@Repository("accountMapper")
public interface AccountMapper {

    List<Account> findAll();

    void insert(Account account);
}
