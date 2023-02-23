package com.jb.service;

import com.jb.entity.PageResult;
import com.jb.entity.QueryPageBean;
import com.jb.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealService {
    public void add(Setmeal setmeal,Integer[] checkgroupIds);
    public PageResult findPage(QueryPageBean queryPageBean);
    public List<Setmeal> findAll();
    public Setmeal findById(Integer id);
    public List<Map> getSetmealReport();
}
