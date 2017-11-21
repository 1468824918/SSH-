package com.lanou.hr.dao;
import com.lanou.hr.domain.Department;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
public interface DepartmentDao {
    List<Department> findAll();

    void addOrEditPre(Department department);

    //分页
    int getTotalDepartment();

    List<Department> findDepartmentByPage(int startIndex, int pageSize);
}
