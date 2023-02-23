package com.jb.service;

import com.jb.entity.PageResult;
import com.jb.entity.QueryPageBean;
import com.jb.pojo.CheckGroup;

import java.util.List;

public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);
    public PageResult findPage(QueryPageBean pageBean);
    public CheckGroup findById(Integer id);
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);
    public List<CheckGroup> findAll();
    public void delete(Integer id);
}
