package com.luci.nl.routing.employee.dao.repository;

import com.luci.nl.routing.employee.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

//    @Query("SELECT e FROM Employee e WHERE CONCAT() LIKE %?1% ")
//    Page<Employee> findAll(String keyword, Pageable pageable);
}
