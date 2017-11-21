package com.lanou.hr.action;

import base.BaseAction;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.impl.StaffServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import util.CrmStringUtils;
import util.PageBean;
import java.util.List;

/**
 * Created by dllo on 17/11/9.
 */
//@Controller("staffAction")
@Scope("prototype")
public class StaffAction extends BaseAction<Staff,StaffServiceImpl> {
    private Post post = new Post();
    private String depID;
    private String postId;
    private String staffId;
    private List<Department> departmentList;
    private List<Post> postList;
    private List<Staff> staffs;

    private String oldPassword;
    private String newPassword;
    private String reNewPassword;


    /**
     * 员工登录
     * @return
     */
    public String login() {
        Staff s = service.login(getModel().getLoginName(), CrmStringUtils.getMD5Value(getModel().getLoginPwd()));
        if (s != null) {
            ServletActionContext.getRequest().getSession().setAttribute("staff", getModel());
            return SUCCESS;
        }
        addFieldError("msg", "用户名密码不匹配");
        return ERROR;
    }


    /**
     * 登录拦截
     * @return
     */
    @SkipValidation
    public String interceptor() {
        return SUCCESS;
    }

    /**
     * 查询所有员工部门
     * @return
     */
    @SkipValidation
    public String staffFindDepartment() {
        departmentList = service.staffFindDepartment();
        return SUCCESS;
    }

    /**
     * 查询员工的职位
     * @return
     */
    @SkipValidation
    public String findPosts() {
        postList = service.findPost(depID);
        return SUCCESS;
    }

    /**
     * 高级查询
     * 根据 postId  depID 查询员工
     * @return
     */
    @SkipValidation
    public String findAll() {
        departmentList = service.staffFindDepartment();
        staffs = service.findPostPostIdAndDepID(postId, depID, getModel().getStaffName());
        return SUCCESS;
    }


    /**
     * 添加
     * 员工的表单数据
     * @param
     */
    @SkipValidation
    public String saveStaff() {
        service.saveStaff(getModel());
        departmentList = service.staffFindDepartment();
        staffs = service.findPostPostIdAndDepID(postId, depID, getModel().getStaffName());
        return SUCCESS;
    }

    /**
     * 编辑
     * 修改员工信息
     * @return
     */
    @SkipValidation
    public String updateStaff() {
        service.updateStaff(getModel());
        departmentList = service.staffFindDepartment();
        staffs = service.findPostPostIdAndDepID(postId, depID, getModel().getStaffName());
        return SUCCESS;
    }

    /**
     * 修改密码
     * @return
     */
    @SkipValidation
    public String updatePassword() {
        Staff staff1 = (Staff) ServletActionContext.getRequest().getSession().getAttribute("staff");
        if (!(staff1.getLoginPwd().equals(oldPassword))||!newPassword.equals(reNewPassword)) {
            addActionError("密码输入错误");
            return ERROR;
        } else {
            service.updateStaffLoginPwd(staff1, CrmStringUtils.getMD5Value(reNewPassword));
            return SUCCESS;
        }
    }


    /**
     * 重新登录
     * @return
     */
    @SkipValidation
    public String againLogin(){
//        ActionContext.getContext().getSession().remove("staff");
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }


    private int pageNum;
    private int pageSize=5;


    /**
     * 分页
     * @return
     */
    @SkipValidation
    public String findStaffByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Staff> all = service.findStaffByPage(getModel(),pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
        return SUCCESS;
    }


    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
