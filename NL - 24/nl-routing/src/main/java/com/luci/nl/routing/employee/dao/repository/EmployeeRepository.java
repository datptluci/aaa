package com.luci.nl.routing.employee.dao.repository;

import com.luci.nl.routing.employee.dao.entity.Employee;
import com.luci.nl.routing.employee.service.pagination.PageParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    @Query("Select e from Employee e where e.accountStatus like %?1%")
    Page<Employee> findByStatus(Pageable pageable,String accountStatus);


//    Page<Employee> filterByKey(Pageable pageable, Map<String,String> filterBy);


    @Query(value = "Select e from Employee e where :key = :value", nativeQuery = true)
    Page<Employee> test(Pageable pageable, String key, String value );
}
