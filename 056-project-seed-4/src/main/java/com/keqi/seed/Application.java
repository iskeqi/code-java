package com.keqi.seed;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/*@Slf4j*/
@Log4j2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // log.debug((Supplier<String>) () -> "http://localhost:21803/seed/doc.html");
        // log.debug((Supplier<String>) Application::f);
        // log.debug(f());
        /*log.info((Supplier<String>) Application::f);*/

        log.debug(Application::f);
    }

    private static String f() {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        return uuid.toString();
    }
}
