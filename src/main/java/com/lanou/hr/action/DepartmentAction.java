package com.lanou.hr.action;
import base.BaseAction;
import com.lanou.hr.domain.Department;
import com.lanou.hr.service.impl.DepartmentServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import util.PageBean;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
//@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department,DepartmentServiceImpl> {
    private List<Department> list;

    /**
     * 查询所有部门
     * @return
     */
    public String findAll(){
        list = service.findAll();
        return SUCCESS;
    }

    /**
     * 插入部门
     * @return
     */
    public String addOrEditPre(){
        if ("".equals(getModel().getDepName())){
            addActionError("部门不能为空");
            return ERROR;
        }else {
            service.addOrEditPre(getModel());
        }
        return SUCCESS;
    }


    private int pageNum;
    private int pageSize=5;


    /**
     * 分页
     * @return
     */
    @SkipValidation
    public String findDepartmentByPage(){
        if (pageNum==0){
            pageNum=1;
        }
        PageBean<Department> all = service.findDepartmentByPage(getModel(),pageNum,pageSize);
        ActionContext.getContext().getSession().put("pageBean",all);
        return SUCCESS;
    }



    public List<Department> getList() {
        return list;
    }

    public void setList(List<Department> list) {
        this.list = list;
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
