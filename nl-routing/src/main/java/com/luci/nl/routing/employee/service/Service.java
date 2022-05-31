package com.luci.nl.routing.employee.service;

import org.springframework.data.domain.Page;

public class Service {
    private IEmployeeService iEmployeeService;

    public Service() {
    }
    public Service(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }
    public Page<EmployeeDTO> findAll(int pageNum,int pageSize,String sortField,String sortDir){
        return iEmployeeService.getEmployees(pageNum,pageSize,sortField,sortDir);
    }
}
