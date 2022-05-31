package com.luci.nl.routing.employee.controller;

import com.luci.nl.routing.employee.service.EmployeeDTO;
import com.luci.nl.routing.employee.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GetEmployeeController {

    @Autowired
    public Service service;

    @GetMapping("/employees/page/{pageNum}")
    public Page<EmployeeDTO> getEmployees(@PathVariable(name="pageNum",required = false) int pageNum,
                                          @RequestParam(value = "pageSize",required = false) int pageSize,
                                          @RequestParam(value ="sortField",required = false) String sortField,
                                          @RequestParam(value = "sortDir",required = false) String sortDir){
        return service.findAll(pageNum,pageSize,sortField,sortDir);
    }
    @GetMapping("/hello")
    public String gg(){
        return "hello";
    }
}
