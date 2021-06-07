package com.coinker.spi.demo1;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Cui Shenpeng
 * @Classname Test
 * @Description TODO
 * @Date 2021/6/7 21:58
 */
public class Test {

    public static void main(String[] args) {
        Iterator<SPIService> providers = Service.providers(SPIService.class);
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        while (providers.hasNext()) {
            SPIService ser = providers.next();
            ser.execute();
        }

        System.out.println("--------------------------------");

        for (SPIService ser : load) {
            ser.execute();
        }
    }

}
