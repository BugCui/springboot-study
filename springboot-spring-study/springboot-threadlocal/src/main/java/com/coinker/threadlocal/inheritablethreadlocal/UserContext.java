package com.coinker.threadlocal.inheritablethreadlocal;

import com.coinker.threadlocal.threadlocal.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Cui Shenpeng
 * @Classname UserContext
 * @Date 2021/9/17 10:16
 */
public class UserContext {

    private static InheritableThreadLocal<UserEntity> userHolder = new InheritableThreadLocal<>();

    public static UserEntity getUser() {

        return userHolder.get();

    }

    public static void setUser(UserEntity user) {

        userHolder.set(user);

    }

    public static void clean() {

        userHolder.remove();

    }


    public static void main(String[] args) throws InterruptedException {
        test3();
    }


    public static void test3() throws InterruptedException {

        UserEntity userEntity = new UserEntity();

        userEntity.setUserName("mzt");

        UserContext.setUser(userEntity);

        UserEntity user = UserContext.getUser();

        Assert.assertNotNull(user);

        Assert.assertEquals(user.getUserName(), "mzt");

        new Thread(() -> {

            final UserEntity user1 = UserContext.getUser();

            Assert.assertNotNull(user1);

            Assert.assertEquals(user1.getUserName(), "mzt");

        }).start();

        TimeUnit.MINUTES.sleep(1);

    }
}



