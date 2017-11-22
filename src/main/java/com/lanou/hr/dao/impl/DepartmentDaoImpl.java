package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.DepartmentDao;
import com.lanou.hr.domain.Department;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import util.PageHibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Repository("departmentDao")
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

    /**
     * 查询所有部门
     *
     * @return
     */
    @Override
    public List<Department> findAll() {
        return (List<Department>) getHibernateTemplate().find("from Department crm_department");

    }

    /**
     * 插入部门
     *
     * @param department
     */
    @Override
    public void addOrEditPre(Department department) {
        if (department.getDepID().equals("")) {
            getHibernateTemplate().save(department);
        } else {
            getHibernateTemplate().saveOrUpdate(department);
        }
    }


    /**
     * 分页
     *
     * @return
     */
    @Override
    public int getTotalDepartment() {
        String sql = "select count(d) from Department d where 1=1";
        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }


    @Override
    public List<Department> findDepartmentByPage(int startIndex, int pageSize) {
        String sql = "from Department where 1=1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Department>(sql, startIndex, pageSize));
    }
}
