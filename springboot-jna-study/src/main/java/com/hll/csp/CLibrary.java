package com.hll.csp;

import com.sun.jna.Library;

/**
 * @author Cui Shenpeng
 * @Classname JavaUseCnative
 * @Description TODO
 * @Date 2021/7/7 9:07
 */
public interface CLibrary extends Library {
    CLibrary INSTANCE = JnaUtil.INSTANCE;

    /**
     * 初始化SDK 注意：调用SDK其他接口前必须先调用此接口！
     *
     */

    int add(int a, int b);

    void addArray(int[] a, int[] b, int[] c, int len);

    String stringFun(String str1, String str2);
}
