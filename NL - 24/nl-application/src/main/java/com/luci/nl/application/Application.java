package com.luci.nl.application;

import com.luci.nl.routing.employee.ServiceConfig;
import com.luci.nl.routing.employee.dao.repository.EmployeeRepositoryCustom;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootApplication()
@Import(ServiceConfig.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
