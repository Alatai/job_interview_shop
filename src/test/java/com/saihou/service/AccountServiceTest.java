package com.saihou.service;

import com.saihou.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Saihou
 * @version 1.0
 * @date 2021/04/17 21:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-core.xml"})
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();

        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
