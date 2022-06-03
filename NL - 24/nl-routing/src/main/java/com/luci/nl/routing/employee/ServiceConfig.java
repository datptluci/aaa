package com.luci.nl.routing.employee;

import com.luci.nl.routing.employee.service.IEmployeeService;
import com.luci.nl.routing.employee.service.Service;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@ComponentScan({"com.luci.nl.routing.employee.dao.entity","com.luci.nl.routing.employee.controller","com.luci.nl.routing.employee.dao.impl","com.luci.nl.routing.employee.dao.repository"})
@EntityScan("com.luci.nl.routing.employee.dao.entity")
@EnableJpaRepositories("com.luci.nl.routing.employee.dao.repository")
public class ServiceConfig {
    @Bean
    public Service service(IEmployeeService iEmployeeService){
        return new Service(iEmployeeService);
    }
}
