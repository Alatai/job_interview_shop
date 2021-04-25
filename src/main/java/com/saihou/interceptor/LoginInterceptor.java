package com.saihou.interceptor;

import com.saihou.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログインインターセプター
 *
 * @author saihou
 * @date 2021/04/25
 */
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * オーダーの請求の前、ログインしているかを確認する
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String ctx = session.getServletContext().getContextPath();

        if (user == null) {
            response.sendRedirect(ctx + "/user/login");

            return false;
        }

        return true;
    }
}
