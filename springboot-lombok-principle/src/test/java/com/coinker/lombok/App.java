package com.coinker.lombok;


import com.coinker.lombok.mylombok.Getter;

/**
 * @author Cui Shenpeng
 * @Classname Test
 * @Description TODO
 * @Date 2021/6/8 17:24
 */
@Getter
public class App {
    private String value;

    private String value2;

    public App(String value) {
        this.value = value;
    }

    public static void main(String[] args) {
        App app = new App("it works");
//        System.out.println(app.getValue());
    }
}
