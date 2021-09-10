package com.coinker.springbootconditional.conditional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 当前工程下的bean实体测试
 */
@RestController
public class BeanController {

    @Autowired
    private SystemBean windows;


    @Autowired
    private SystemBean mac;

    @Autowired
    private SystemBean linux;


    @GetMapping("system")
    public void test() {
        if (windows != null) {
            System.out.println("windows = " + windows);
        }

        if (mac != null) {
            System.out.println("linux = " + mac);
        }

        if (linux != null) {
            System.out.println("linux = " + linux);
        }
    }
}
