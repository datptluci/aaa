package com.luci.nl.routing.employee.controller;

import com.luci.nl.routing.employee.service.EmployeeDTO;
import com.luci.nl.routing.employee.service.Service;
import com.luci.nl.routing.employee.service.pagination.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
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
//    @GetMapping("/employees/filterByAccountStatus/{pageNum}")
//    public Page<EmployeeDTO> filterByAccountStatus(
//            @RequestParam(value = "accountStatus",required = false) String accountStatus,
//            @PathVariable(name="pageNum",required = false) int pageNum){
//        return service.filterByAccountStatus(pageNum,accountStatus);
//    }
//    @GetMapping("/employees/filterByKey/{pageNum}")
//    public Page<EmployeeDTO> filterByKeyy(
//            @RequestParam(value = "filterBy",required = false) Map<String,String> filterBy,
//            @PathVariable(name="pageNum",required = false) int pageNum,
//            @RequestParam(name="pageSize",required = false) int pageSize){
//        return service.filterByKey(pageNum,pageSize,filterBy);
//    }
//    @GetMapping("/employees/filter/")
//    public Page<EmployeeDTO> filterByKey(@RequestParam(value = "filterBy", required = false) Map<String, String> filterBy){
//
//        return service.filterBy(filterBy);
//    }



//    @PostMapping("/hello/filterBy/{pageNum}")
//    public Page<EmployeeDTO> gg(@RequestBody Map<String,String> filterBy,
//                                @PathVariable(name="pageNum",required = false) int pageNum,
//                                @RequestParam(name="pageSize",required = false) int pageSize,
//                                @RequestParam(value ="sortField",required = false) String sortField,
//                                @RequestParam(value = "sortDir",required = false) String sortDir){
//        return service.getE(new PageParam());
//    }
@PostMapping("/hello/filterBy/{pageNum}")
public Page<EmployeeDTO> gg(@RequestParam Map<String,String> filterBy,
                            @PathVariable(name="pageNum",required = false) int pageNum,
                            @RequestParam(name="pageSize",required = false) int pageSize,
                            @RequestParam(value ="sortField",required = false) String sortField,
                            @RequestParam(value = "sortDir",required = false) String sortDir){

    return service.getE(pageNum,pageSize,sortField,sortDir,filterBy);
}
}
