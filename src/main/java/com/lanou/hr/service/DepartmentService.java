package com.lanou.hr.service;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import util.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepartmentService {

    List<Department> findAll();

    void addOrEditPre(Department department);

    //分页
    PageBean<Department> findDepartmentByPage(Department department, int pageNum, int pageSize);
}
