package com.luci.nl.routing.employee.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<EmployeeDTO> getEmployees(int pageNum,int pageSize,String sortField,String sortDir);
    int totalItem();

}
