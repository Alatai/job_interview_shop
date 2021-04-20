package com.saihou.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saihou.entity.Category;
import com.saihou.entity.User;
import com.saihou.service.UserService;
import com.saihou.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ユーザ
 *
 * @author saihou
 * @date 2021/04/20
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/index", "/list"})
    public String list(Model model, Integer currentPage) {
        currentPage = currentPage == null ? 1 : currentPage;
        PageHelper.startPage(currentPage, 8);
        List<User> users = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);

        model.addAttribute("title", "ユーザ管理");
        model.addAttribute("users", users);
        model.addAttribute("pageInfo", pageInfo);

        return "/admin/user/list";
    }

}
