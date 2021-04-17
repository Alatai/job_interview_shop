package com.saihou.controller;

import com.saihou.entity.Account;
import com.saihou.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Saihou
 * @version 1.0
 * @date 2021/04/17 22:24
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String testFindAll(Model model) {
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list", accounts);

        return "list";
    }

    @RequestMapping("/insert")
    public String testInsert(Account account) {
        System.out.println(account);

        accountService.insert(account);

        return "success";
    }

    @RequestMapping("/hello")
    public String helloFreeMaker(Model model) {
        String word0 = "Hello ";
        String word1 = "World!";

        model.addAttribute("title", "ftl模板页面");
        model.addAttribute("word0", word0);
        model.addAttribute("word1", word1);

        return "hello";
    }

}
