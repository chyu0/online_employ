package com.chenyu.employ.front.utils;

import javax.servlet.http.HttpServletRequest;

import com.chenyu.employ.user.model.User;

public class SessionManager {
	public static User get(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("User");
    }

    public static void put(User user, HttpServletRequest request) {
        request.getSession().setAttribute("User", user);
    }

    public static void clear(HttpServletRequest request) {
        request.getSession().removeAttribute("User");
    }
}
