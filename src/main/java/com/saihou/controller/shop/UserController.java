package com.saihou.controller.shop;

import com.saihou.entity.User;
import com.saihou.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author saihou
 * @date 2021/04/22
 */
@SuppressWarnings({"SpringJavaAutowiredFieldsWarningInspection"})
@Controller("shopUserController")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "/shop/user/register";
    }

    @RequestMapping("/register.do")
    public String register(Model model, User user) {
        String name = user.getName();
        name = HtmlUtils.htmlEscape(name);
        user.setName(name);

        boolean isExist = userService.isExist(name);

        if (isExist) {
            String msg = "ユーザネームは既に存在しています。";
            model.addAttribute("msg", msg);

            return "/shop/user/register";
        }

        userService.register(user);

        return "redirect:/user/login";
    }

    @RequestMapping("/login")
    public String login() {
        return "/shop/user/login";
    }

    @RequestMapping("/login.do")
    public String login(Model model, HttpSession session, String name, String password) {
        name = HtmlUtils.htmlEscape(name);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);
            User user = userService.findByName(name);
            session.setAttribute("user", user);

            return "redirect:/index";
        } catch (AuthenticationException exp) {
            model.addAttribute("msg", "ユーザネームとパスワードが間違っています。");

            return "/shop/user/login";
        }
    }

    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();

        if (subject.isAuthenticated()) {
            subject.logout();
        }

        return "redirect:/index";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin() {
        Subject subject = SecurityUtils.getSubject();

        if (!subject.isAuthenticated()) {
            return "fail";
        }

        return "success";
    }

    @RequestMapping("/modalLogin")
    @ResponseBody
    public String modalLogin(HttpSession session, @RequestBody Map<String, String> params) {
        String name = params.get("name");
        String password = params.get("password");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {
            subject.login(token);
            User user = userService.findByName(name);
            session.setAttribute("user", user);

            return "success";
        } catch (AuthenticationException exp) {
            return "fail";
        }
    }
}
