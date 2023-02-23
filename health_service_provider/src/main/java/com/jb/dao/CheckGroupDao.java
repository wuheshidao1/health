package com.jb.dao;

import com.github.pagehelper.Page;
import com.jb.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

public interface CheckGroupDao {
    public void add(CheckGroup checkGroup);

    public void setCheckGroupAndCheckItem(Map<String, Integer> map);

    public Page<CheckGroup> findByCondition(String queryString);

    public CheckGroup findById(Integer id);

    public void edit(CheckGroup checkGroup);

    public void deleteAssociation(Integer checkgroupId);

    public List<CheckGroup> findAll();

    public void delete(Integer id);
}
