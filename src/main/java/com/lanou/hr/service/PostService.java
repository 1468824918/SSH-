package com.lanou.hr.service;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import util.PageBean;

import java.util.List;

public interface PostService {

    void addSavePost(Post post);

    List<Post> findPost();

    List<Department> findDepartment();

    //分页
    PageBean<Post> findPostByPage(Post post, int pageNum, int pageSize);
}
