package com.coinker.threadlocal.threadlocal;

/**
 * @author Cui Shenpeng
 * @Classname UserContext
 * @Date 2021/9/17 10:12
 */

public class UserContext {

    private UserContext() {
    }

    private static ThreadLocal<User> userHolder = new ThreadLocal<>();

    public static User getUser() {
        return userHolder.get();
    }

    public static void setUser(User user) {
        userHolder.set(user);
    }

    public static void clean() {
        userHolder.remove();
    }

}

