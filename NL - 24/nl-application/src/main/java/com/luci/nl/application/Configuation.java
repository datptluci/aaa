package com.luci.nl.application;

import com.luci.nl.routing.employee.dao.impl.EmployeeServiceImpl;
import com.luci.nl.routing.employee.dao.repository.EmployeeRepository;
import com.luci.nl.routing.employee.service.IEmployeeService;
import com.luci.nl.routing.employee.service.Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuation {
//    @Bean
//    public Service service(IEmployeeService iEmployeeService){
//        return new Service(iEmployeeService);
//    }
    @Bean
    public IEmployeeService iEmployeeService(EmployeeRepository employeeRepository){
        return new EmployeeServiceImpl(employeeRepository);
    }
}
