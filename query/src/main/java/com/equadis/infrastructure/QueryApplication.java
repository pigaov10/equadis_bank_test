package com.equadis.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class QueryApplication {
    public static void main(String[] args) {
        SpringApplication.run(QueryApplication.class, args);
    }
}
