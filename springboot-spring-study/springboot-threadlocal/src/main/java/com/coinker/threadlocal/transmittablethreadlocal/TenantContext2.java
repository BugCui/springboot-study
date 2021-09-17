package com.coinker.threadlocal.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Cui Shenpeng
 * @Classname TenantContext2
 * @Date 2021/9/17 10:31
 */
@Slf4j
public class TenantContext2 {

    private static TransmittableThreadLocal<String> tenantHolder = new TransmittableThreadLocal<>();

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

        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

        TenantContext2.setTenantId("mzt_" + 1);

        ttlExecutorService.submit(() -> {

            String tenantId = TenantContext2.getTenantId();

            LOGGER.info("#########, {}", tenantId);

            //TenantContext.clean();

        });

        TimeUnit.SECONDS.sleep(2);

        TenantContext2.setTenantId("mzt_" + 2);

        ttlExecutorService.submit(() -> {

            LOGGER.info("#########, {}", TenantContext2.getTenantId());

            // TenantContext.clean();

        });

        Thread.sleep(2000L);

    }


}
