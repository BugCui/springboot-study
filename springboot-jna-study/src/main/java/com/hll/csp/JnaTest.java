package com.hll.csp;


/**
 * @author Cui Shenpeng
 * @Classname JnaTest
 * @Description TODO
 * @Date 2021/7/7 10:13
 */
public class JnaTest {

    public static void main(String[] args) {
        testVixHz_InitSDK();
    }

    /**
     * 初始化SDK
     */
    public static void testVixHz_InitSDK() {
        int sum = CLibrary.INSTANCE.add(1, 2);
        System.out.println("1+2= " + sum);
        System.out.println("hello world");
    }
}
