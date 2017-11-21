package com.lanou.hr.service.impl;

import com.lanou.hr.dao.PostDao;
import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.PostService;
import org.springframework.stereotype.Service;
import util.PageBean;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 17/11/10.
 */
@Service("postService")
public class PostServiceImpl implements PostService{

    @Resource(name = "postDao")
    private PostDao postDao;

    /**
     * 职务管理(插入职务)
     * @param post
     */
    @Override
    public void addSavePost(Post post) {
        postDao.addSavePost(post);
    }
    /**
     * 查询所有职务
     * @param
     * @return
     */

    @Override
    public List<Post> findPost() {
        return postDao.findPost();
    }


    /**
     * 查询所有部门
     * @return
     */
    @Override
    public List<Department> findDepartment() {
        return postDao.findDepartment();
    }


    /**
     * 分页
     * @param post
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Post> findPostByPage(Post post, int pageNum, int pageSize) {
        int totalStaff = postDao.getTotalPost();
        PageBean<Post> pageBean = new PageBean<Post>(pageNum,pageSize,totalStaff);
        List<Post> data = postDao.findPostByPage(pageBean.getStartIndex(), pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }


    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
