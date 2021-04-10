package com.shop.mirosigns;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MirosignsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MirosignsApplication.class, args);
log.info("Hello aplikacja wystartowala");
    }

}
