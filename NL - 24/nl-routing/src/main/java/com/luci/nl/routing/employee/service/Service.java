package com.luci.nl.routing.employee.service;

import com.luci.nl.routing.employee.service.pagination.PageParam;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public class Service {
    private IEmployeeService iEmployeeService;

    public Service() {
    }
    public Service(IEmployeeService iEmployeeService){
        this.iEmployeeService = iEmployeeService;
    }
    public Page<EmployeeDTO> findAll(int pageNum,int pageSize,String sortField,String sortDir){
        return iEmployeeService.getEmployee(pageNum,pageSize,sortField,sortDir);
    }
    public List<EmployeeDTO> getAll(){
        return iEmployeeService.getAll();
    }
//    public Page<EmployeeDTO> filterByAccountStatus(int pageNum,String accountStatus){
//        return  iEmployeeService.findByStatus(pageNum,accountStatus);
//    }
//    public Page<EmployeeDTO> filterByKey(int pageNum,int pageSize,Map<String,String> filterBy){
//        return  iEmployeeService.filterByKey(pageNum,pageSize,filterBy);
//    }

    public Page<EmployeeDTO> getE(int pageNum, int pageSize, String sortField, String sortDir,Map<String,String> filterBy ){
        return iEmployeeService.getE(pageNum,pageSize,sortField,sortDir,filterBy);
    }
}
