package com.saihou.controller.shop;

import com.saihou.entity.User;
import com.saihou.service.UserService;
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

        userService.insert(user);

        return "redirect:/user/login";
    }

    @RequestMapping("/success")
    public String registerSuccess() {
        return "/shop/user/success";
    }

    @RequestMapping("/login")
    public String login() {
        return "/shop/user/login";
    }

    @RequestMapping("/login.do")
    public String login(Model model, HttpSession session, String name, String password) {
        name = HtmlUtils.htmlEscape(name);
        User user = userService.findByCondition(name, password);

        if (null == user) {
            model.addAttribute("msg", "ユーザネームとパスワードが間違っています。");
            return "/shop/user/login";
        }

        session.setAttribute("user", user);

        return "redirect:/index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/index";
    }

    @RequestMapping("/checkLogin")
    @ResponseBody
    public String checkLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "fail";
        }

        return "success";
    }

    @RequestMapping("/modalLogin")
    @ResponseBody
    public String modalLogin(HttpSession session, @RequestBody Map<String, String> params) {
        String name = params.get("name");
        String password = params.get("password");

        User user = userService.findByCondition(name, password);

        if (user == null) {
            return "fail";
        }

        session.setAttribute("user", user);

        return "success";
    }
}
