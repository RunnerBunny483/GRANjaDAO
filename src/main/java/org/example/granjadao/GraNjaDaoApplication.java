package org.example.granjadao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GraNjaDaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraNjaDaoApplication.class, args);
    }

}
