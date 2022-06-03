package com.luci.nl.routing.employee.dao.repository;

import com.luci.nl.routing.employee.ServiceConfig;
import com.luci.nl.routing.employee.dao.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;
import java.util.Map;

@DataJpaTest
@Rollback(value = true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(ServiceConfig.class)
public class TestRepository {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeRepositoryCustom custom;

    @Test
    void testConnect(){
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(e -> System.out.println(e));
    }

    @Test
    void testQuerry(){
        Map<String,String> filterBy = new HashMap<>();
        filterBy.put("accountStatus","đang hoạt động");
        filterBy.put("sex","nam");
        System.out.println(custom.filterA(filterBy));

    }
    @Test
    void testQueryPage(){
        Map<String,String> filterBy = new HashMap<>();
        Pageable pageable =PageRequest.of(0,1);
        filterBy.put("accountStatus","đang hoạt động");
        filterBy.put("sex","nam");
        System.out.println(custom.filter(pageable,filterBy));
        Assertions.assertThat(custom.filter(pageable,filterBy));

    }
}