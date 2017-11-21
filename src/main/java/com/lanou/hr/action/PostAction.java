package com.lanou.hr.action;

import base.BaseAction;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.service.PostService;
import com.lanou.hr.service.impl.PostServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import util.PageBean;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
//@Controller("postAction")
@Scope("prototype")
public class PostAction extends BaseAction<Post,PostServiceImpl> {

    private Department department = new Department();
    private String depID;
    private String depName;
    private List<Post> posts;
    private List<Department> departmentList;

    /**
     * 职务管理(插入职务)
     *
     * @return
     */
    public String addSavePost() {
        getModel().setDepartment(new Department(depID,depName));
        service.addSavePost(getModel());

        return SUCCESS;
    }

    /**
     * 查询所有职务
     *
     * @return
     */
    public String findPost() {
        posts = service.findPost();
        return SUCCESS;
    }


    /**
     * 查询所有部门
     * @return
     */
    public String findDepartment(){
        departmentList = service.findDepartment();
        return SUCCESS;
    }


    private int pageNum;
    private int pageSize=5;


    /**
     * 分页
     * @return
     */
    @SkipValidation
    public String findPostByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Post> all = service.findPostByPage(getModel(),pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
        return SUCCESS;
    }



    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
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
}
