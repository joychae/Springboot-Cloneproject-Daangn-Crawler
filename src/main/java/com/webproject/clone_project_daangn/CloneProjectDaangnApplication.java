package com.webproject.clone_project_daangn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CloneProjectDaangnApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloneProjectDaangnApplication.class, args);
    }

}
