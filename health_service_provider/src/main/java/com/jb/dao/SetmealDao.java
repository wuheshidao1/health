package com.jb.dao;

import com.github.pagehelper.Page;
import com.jb.pojo.CheckItem;
import com.jb.pojo.Setmeal;

import java.util.List;
import java.util.Map;

public interface SetmealDao {
    public void add(Setmeal setmeal);
    public void setSetmealAndCheckGroup(Map<String, Integer> map);
    public Page<CheckItem> findByCondition(String queryString);
    public List<Setmeal> findAll();
    public Setmeal findById4Detail(Integer id);
    public List<Map> getSetmealReport();
}
