package org.taru.producttracing;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Mapper
public class ProductTracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductTracingApplication.class, args);
    }

}
