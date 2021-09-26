package com.coinker.moquette;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class SpringbootMoquetteApplication {

//    private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootMoquetteApplication.class);

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(SpringbootMoquetteApplication.class);
        final ApplicationContext context = application.run(args);
        MoquetteServer server = context.getBean(MoquetteServer.class);
        server.startServer();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            server.stop();
            LOGGER.info("Moquette Server stopped");
        }));
    }

}
