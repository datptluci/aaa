package com.luci.nl.routing.employee.service.pagination;

import lombok.Data;

import java.util.Map;

@Data
public class PageParam {
    private int pageNum;
    private int pageSize;
    private String sortField;
    private SortDirection sortDirection;
    private Map<String,String> filterBy;
}

