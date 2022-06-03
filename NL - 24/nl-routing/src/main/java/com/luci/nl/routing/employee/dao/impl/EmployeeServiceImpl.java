package com.luci.nl.routing.employee.dao.impl;

import com.luci.nl.routing.employee.dao.entity.Employee;
import com.luci.nl.routing.employee.dao.repository.EmployeeRepository;
import com.luci.nl.routing.employee.dao.repository.EmployeeRepositoryCustom;
import com.luci.nl.routing.employee.service.EmployeeDTO;
import com.luci.nl.routing.employee.service.IEmployeeService;
import com.luci.nl.routing.employee.service.pagination.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeRepositoryCustom custom;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeServiceImpl(EmployeeRepositoryCustom custom){
        this.custom = custom;
    }
    public EmployeeServiceImpl() {
    }

    @Override
    public List<EmployeeDTO> getAll() {

        List<EmployeeDTO> employeeDTO = new ArrayList<>();
        for (Employee e : employeeRepository.findAll()) {
            employeeDTO.add(convertDAOToDTO(e));
        }
        return employeeDTO;
    }


    @Override
    public Page<EmployeeDTO> getEmployee(int pageNum, int pageSize, String sortField, String sortDir) {


        if (pageNum < 0 & pageSize < 0) {
            return null;
        }

        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);


        Page<EmployeeDTO> page = employeeRepository.findAll(pageable).map(EmployeeServiceImpl::convertDAOToDTO);
        page.getTotalElements();
        page.getTotalPages();
        page.getContent();

        return page;
    }

//    @Override
//    public Page<EmployeeDTO> findByStatus(int pageNum, String accountStatus) {
//        Pageable pageable = PageRequest.of(pageNum - 1, 1);
//        if (accountStatus != null) {
//            return employeeRepository.findByStatus(pageable, accountStatus).map(EmployeeServiceImpl::convertDAOToDTO);
//
//        }
//        return employeeRepository.findAll(pageable).map(EmployeeServiceImpl::convertDAOToDTO);
//
//    }


    @Autowired
    public EntityManager entityManager;



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
@Override
public Page<EmployeeDTO> getE(int pageNum, int pageSize, String sortField, String sortDir, Map<String, String> filterBy) {
    Sort sort = Sort.by(sortField);
    sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);


    Page<EmployeeDTO> page = custom.filter(pageable, filterBy).map(EmployeeServiceImpl::convertDAOToDTO);

    return page;
}

//    @Override
//    public Page<EmployeeDTO> filterByKey(int pageNum, int pageSize, Map<String, String> filterBy) {
//        return null;
//    }



    public static EmployeeDTO convertDAOToDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setEmployeeCode(employee.getEmployeeCode());
        employeeDTO.setAvatar(employee.getAvatar());
        employeeDTO.setUserName(employee.getUserName());
        employeeDTO.setPassword(employee.getPassword());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setMiddleName(employee.getMiddleName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setSex(employee.getSex());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setCitizenIdentification(employee.getCitizenIdentification());
        employeeDTO.setReleaseDate(employee.getReleaseDate());
        employeeDTO.setPublishedPlace(employee.getPublishedPlace());
        employeeDTO.setAddress(employee.getAddress());
        employeeDTO.setAccountStatus(employee.getAccountStatus());
        employeeDTO.setParts(employee.getParts());
        employeeDTO.setDecentralization(employee.getDecentralization());
        employeeDTO.setProject(employee.getProject());
        employeeDTO.setPermission(employee.getPermission());
        employeeDTO.setFactorAuthentication(employee.getFactorAuthentication());
        return employeeDTO;
    }

//    @Override
//    public Page<EmployeeDTO> filterByKey(int pageNum,int pageSize,Map<String,String> filterBy) {
//
//
//
//        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
//
//
//        Page<EmployeeDTO> page = employeeRepository.findAll(pageable).map(EmployeeServiceImpl::convertDAOToDTO) ;
//        page.getTotalElements();
//        page.getTotalPages();
//        page.getContent();
//
//        String sql = "select * from Employee where"+buildWhereClause(filterBy)  ;
//        Query query = entityManager.createQuery(sql);
//
//         query.getResultList();
//         return null;
//    }
    public static Employee convertDTOToDAO(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setId(employeeDTO.getId());
        employee.setEmployeeCode(employeeDTO.getEmployeeCode());
        employee.setAvatar(employeeDTO.getAvatar());
        employee.setUserName(employeeDTO.getUserName());
        employee.setPassword(employeeDTO.getPassword());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setSex(employeeDTO.getSex());
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setCitizenIdentification(employeeDTO.getCitizenIdentification());
        employee.setReleaseDate(employeeDTO.getReleaseDate());
        employee.setPublishedPlace(employeeDTO.getPublishedPlace());
        employee.setAddress(employeeDTO.getAddress());
        employee.setAccountStatus(employeeDTO.getAccountStatus());
        employee.setParts(employeeDTO.getParts());
        employee.setDecentralization(employeeDTO.getDecentralization());
        employee.setProject(employeeDTO.getProject());
        employee.setPermission(employeeDTO.getPermission());
        employee.setFactorAuthentication(employeeDTO.getFactorAuthentication());
        return employee;
    }

}
