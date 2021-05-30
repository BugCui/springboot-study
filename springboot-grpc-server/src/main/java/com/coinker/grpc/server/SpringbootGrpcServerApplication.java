package com.coinker.grpc.server;

import com.coinker.grpc.server.annotation.GrpcService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
public class SpringbootGrpcServerApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        // 启动SpringBoot web
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringbootGrpcServerApplication.class, args);
        Map<String, Object> grpcServiceBeanMap = configurableApplicationContext.getBeansWithAnnotation(GrpcService.class);
        ServiceManager serviceManager = configurableApplicationContext.getBean(ServiceManager.class);
        serviceManager.loadService(grpcServiceBeanMap);
    }

}
