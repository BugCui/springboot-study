package com.coinker.threadlocal.transmittablethreadlocal;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Cui Shenpeng
 * @Classname TenantContext
 * @Description TODO
 * @Date 2021/9/17 10:27
 */
@Slf4j
public class TenantContext {

    private static InheritableThreadLocal<String> tenantHolder = new InheritableThreadLocal<>();

    private static String getTenantId() {
        return tenantHolder.get();
    }

    private static void setTenantId(String s) {
        tenantHolder.set(s);
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    @Test
    public static void test1() throws InterruptedException {

        ExecutorService ttlExecutorService = Executors.newFixedThreadPool(1);

        TenantContext.setTenantId("mzt_" + 1);

        ttlExecutorService.submit(() -> {

            String tenantId = TenantContext.getTenantId();

            LOGGER.info("#########, {}", tenantId);

            //TenantContext.clean();

        });

        TimeUnit.SECONDS.sleep(2);

        TenantContext.setTenantId("mzt_" + 2);

        ttlExecutorService.submit(() -> {

            LOGGER.info("#########, {}", TenantContext.getTenantId());

            // TenantContext.clean();

        });

        Thread.sleep(2000L);

    }


}
