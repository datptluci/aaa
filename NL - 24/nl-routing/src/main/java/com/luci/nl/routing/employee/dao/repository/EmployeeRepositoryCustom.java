package com.luci.nl.routing.employee.dao.repository;


import com.luci.nl.routing.employee.dao.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryCustom  {
    @PersistenceContext
    private EntityManager en;

public Page<Employee> filter(Pageable pageable, Map<String, String> filterBy){

    CriteriaBuilder builder = en.getCriteriaBuilder();
    CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
    Root<Employee> root = query.from(Employee.class);
        CriteriaQuery<Employee> select = query.select(root);
    for (Map.Entry<String,String> entry : filterBy.entrySet()){
        if(filterBy.size()>1){
            Predicate test = builder.equal(root.get(entry.getKey()),entry.getValue());
            Predicate condition = builder.and(test,test);
            select.where(condition);
        }
        else {
            select.where(builder.equal(root.get(entry.getKey()),entry.getValue()));
        }
    }
    List<Employee> list = en.createQuery(query).getResultList();
    Page<Employee> p = new PageImpl<>(list);
    p.getTotalElements();
    p.getTotalPages();
    p.getContent();
    return p;
}

public List<Employee> filterA(Map<String, String> filterBy){
        CriteriaBuilder builder = en.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        CriteriaQuery<Employee> select = query.select(root);

        for (Map.Entry<String,String> entry : filterBy.entrySet()){
            Predicate test = builder.equal(root.get(entry.getKey()),entry.getValue());
            if(filterBy.size()>1){
                select.where(builder.and(test,test));

            }
            else {
                select.where(test);
            }
        }
        return en.createQuery(query).getResultList();

    }


    //    public Page<Employee> filter(Pageable pageable, PageParam pageParam){
//
//        CriteriaBuilder builder = en.getCriteriaBuilder();
//        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
//        Root<Employee> root = query.from(Employee.class);
////        MapJoin<Employee,String,String> mapJoin = root.join();
//        for (Map.Entry<String,String> entry : pageParam.getFilterBy().entrySet()){
//            query.select(root).where(builder.equal(root.get(entry.getKey()),entry.getValue()));
//        }
//        List<Employee> list = en.createQuery(query).getResultList();
//        Page<Employee> p = new PageImpl<>(list);
//        return p;
//    }
//    private String buildWhereClause(Map<String, String> filterBy) {
//        String whereClause = "";
//        for (Map.Entry<String, String> entry : filterBy.entrySet()) {
//            whereClause += entry.getKey() + "=?" + entry.getValue();
//        }
//        return whereClause;
//    }
}
