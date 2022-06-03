package com.luci.nl.routing.employee.service;

import com.luci.nl.routing.employee.dao.entity.Employee;
import com.luci.nl.routing.employee.service.pagination.PageParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Page<EmployeeDTO> getEmployee(int pageNum,int pageSize,String sortField,String sortDir);

    List<EmployeeDTO> getAll();

//    Page<EmployeeDTO> findByStatus(int pageNum, String accountStatus);
//
//    Page<EmployeeDTO> filterByKey(int pageNum,int pageSize,Map<String,String> filterBy);

//    Page<EmployeeDTO> getE(PageParam pageParam);

    //    @Override
    //    public Page<EmployeeDTO> getE(PageParam pageParam) {
    //        Sort sort = Sort.by(pageParam.getSortField());
    //        sort = pageParam.getSortField().equals("asc") ? sort.ascending() : sort.descending();
    //        Pageable pageable = PageRequest.of(pageParam.getPageNum() - 1, pageParam.getPageSize(), sort);
    //
    //
    //        Page<EmployeeDTO> page = Custom.filter(pageable,pageParam).map(EmployeeServiceImpl::convertDAOToDTO);
    //
    //        return page;
    //    }
    Page<EmployeeDTO> getE(int pageNum, int pageSize, String sortField, String sortDir, Map<String, String> filterBy);
}
