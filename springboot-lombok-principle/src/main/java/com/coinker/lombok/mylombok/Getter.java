package com.coinker.lombok.mylombok;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Cui Shenpeng
 * @Classname Getter
 * @Description TODO
 * @Date 2021/6/8 17:18
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Getter {

    // 注解在编译期起作用。

}

