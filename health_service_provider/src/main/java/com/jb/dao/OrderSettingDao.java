package com.jb.dao;

import com.jb.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {
    public long findCountByOrderDate(Date orderDate);
    public void editNumberByOrderDate(OrderSetting orderSetting);
    public void add(OrderSetting orderSetting);
    public List<OrderSetting> getOrderSettingByMonth(Map<String, String> map);
    public OrderSetting findByOrderDate(Date date);
    public void editReservationsByOrderDate(OrderSetting orderSetting);
}
