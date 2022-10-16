package com.coinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class GraphQlExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlExampleApplication.class, args);
    }

}
