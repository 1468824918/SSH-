package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import util.PageHibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
public class StaffDaoImpl extends HibernateDaoSupport implements StaffDao {


    /**
     * 员工的登录
     */
    @Override
    public Staff login(String loginName,String loginPwd) {
        List<Staff> staffs = (List<Staff>) getHibernateTemplate().find("from Staff staffs where staffs.loginName=? and staffs.loginPwd=?",loginName,loginPwd);
        if (staffs.size()>0){
            return staffs.get(0);
        }
        return null;
    }



    /**
     * 查询员工信息
     *
     * @param staff
     * @return
     */
    @Override
    public List<Staff> find(Staff staff) {
        return (List<Staff>) getHibernateTemplate().find("from Staff crm_staff");
    }




    /**
     * 查找员工所有部门
     *
     * @return
     */
    @Override
    public List<Department> staffFindDepartment() {
        return (List<Department>) getHibernateTemplate().find("from Department dept");
    }



    /**
     * 查询员工职务
     *
     * @param depID
     * @return
     */
    @Override
    public List<Post> findPost(String depID) {
        return (List<Post>) getHibernateTemplate().find("from Post post where department.depID=?", depID);
    }



    /**
     * 根据 postId  depID staffName 查询数据
     * 高级查询
     * @param postId
     * @param depID
     * @return
     */
    @Override
    public List<Staff> findPostPostIdAndDepID(String postId, String depID, String staffName) {

        if (postId==null && depID==null && staffName==null){
            return (List<Staff>) getHibernateTemplate().find("from Staff staff");
        }
        else if (postId==null && !"".equals(depID) && !"".equals(staffName)){
            return (List<Staff>) getHibernateTemplate().find("from Staff staff");
        }
        //条件全部为空
         if ("".equals(postId) && "".equals(depID) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staffs");
        }
        //部门depID和职务postId不为空且staffName为空
        else if (!"".equals(postId) && !"".equals(depID) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where post.postId=? and post.department.depID=?", postId, depID);
        }
        //部门depID不为空且职务postId为空且staffName为空
        else if ("".equals(postId) && !"".equals(depID) && "".equals(staffName)) {
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where post.department.depID=?", depID);
        }
        //部门depID和职务postId为空staffName不为空
        else if ("".equals(postId) && "".equals(depID) && !"".equals(staffName)){
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where staffName like ?","%"+ staffName+ "%");
        }
        //条件全有
            return (List<Staff>) getHibernateTemplate().find("from Staff staff where post.postId=?and post.department.depID=? and staffName=?", postId, depID, staffName);
    }


    /**
     * 员工的表单数据
     *
     * @param staff
     */
    @Override
    public void saveStaff(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
    }



    /**
     * 修改员工信息
     *
     * @param staff
     */
    @Override
    public void updateStaff(Staff staff) {
        getHibernateTemplate().saveOrUpdate(staff);
    }



    /**
     * 修改密码
     * @param staff
     */
    @Override
    public void updateStaffLoginPwd(Staff staff,String reNewPassword) {
        List<Staff> staffList = (List<Staff>) getHibernateTemplate().find("from Staff staff where staff.loginName=?",staff.getLoginName());
        if (staffList.size()>0){
            Staff staff1 = staffList.get(0);
            staff1.setLoginPwd(reNewPassword);
            getHibernateTemplate().update(staff1);
        }
    }




    //分页
    @Override
    public int getTotalStaff() {
        String sql = "select count(s) from Staff s where 1=1";
        List<Long> find = (List<Long>) getHibernateTemplate().find(sql);
        if (find!=null){
            return find.get(0).intValue();
        }
        return 0;
    }


    @Override
    public List<Staff> findStaffByPage(int startIndex, int pageSize) {
        String sql = "from Staff where 1=1";
        return getHibernateTemplate().execute(new PageHibernateCallback<Staff>(sql,startIndex,pageSize));
    }
}
