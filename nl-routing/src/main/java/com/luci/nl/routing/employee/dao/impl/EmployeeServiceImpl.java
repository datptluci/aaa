package com.luci.nl.routing.employee.dao.impl;

import com.luci.nl.routing.employee.dao.entity.Employee;
import com.luci.nl.routing.employee.dao.repository.EmployeeRepository;
import com.luci.nl.routing.employee.service.EmployeeDTO;
import com.luci.nl.routing.employee.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    }

    public EmployeeServiceImpl() {
    }

    @Override
    public Page<EmployeeDTO> getEmployees(int pageNum,int pageSize, String sortField, String sortDir) {

        Sort sort = Sort.by(sortField);
        sort = sortDir.equals("asc") ? sort.ascending() : sort.descending();
        Pageable pageable = PageRequest.of(pageNum-1,pageSize,sort);

//        long startCount = (pageNum -1)*LIMIT +1;
//        long endCount = startCount + LIMIT -1;;
////        int totalPage = (int) Math.ceil(totalItem()/LIMIT);

         Page<EmployeeDTO> page = employeeRepository.findAll(pageable).map(EmployeeServiceImpl::convertDAOToDTO) ;
         
         return page;
    }

    @Override
    public int totalItem() {
        return (int) employeeRepository.count();
    }

    public static EmployeeDTO map(Employee employee){

        return new EmployeeDTO();
    }
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
