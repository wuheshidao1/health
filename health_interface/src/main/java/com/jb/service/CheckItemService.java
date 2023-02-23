package com.jb.service;

import com.jb.entity.PageResult;
import com.jb.entity.QueryPageBean;
import com.jb.pojo.CheckItem;

import java.util.List;

public interface CheckItemService {
    public void add(CheckItem checkItem);
    public PageResult findPage(QueryPageBean queryPageBean);
    public void delete(Integer id);
    public CheckItem findById(Integer id);
    public void edit(CheckItem checkItem);
    public List<CheckItem> findAll();
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer checkgroupId);
}
