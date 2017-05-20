package cn.forage.dao;

import cn.forage.model.Order;

import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface OrderDao {
    public Order getOrderById();
    public Order getOrderByCode();
    public List getOrderByUserId();

    public int insertOneOrder(Order order);
    public int deleteOrderById(int id);
    public int deleteOrderByCode();
    public int updateOneOrder();

}
