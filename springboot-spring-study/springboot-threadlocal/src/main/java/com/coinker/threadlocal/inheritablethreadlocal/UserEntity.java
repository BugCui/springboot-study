package com.coinker.threadlocal.inheritablethreadlocal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cui Shenpeng
 * @Classname UserEntity
 * @Date 2021/9/17 10:17
 */
@Data
@Setter
@Getter
public class UserEntity {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
