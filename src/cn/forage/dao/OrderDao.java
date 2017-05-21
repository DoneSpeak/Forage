package cn.forage.dao;

import cn.forage.model.FoodItem;
import cn.forage.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface OrderDao extends PageDao<Order>{

    //根据餐厅id来获取订单列表
    public ArrayList<Order>getByRestaurantId(int restaurantId);
    //根据订单id
    public ArrayList<Order>getUserOrders(int orderId);
    //每一份订单的总价
    public float getTotal(int orderId)throws Exception;
    //添加订单
    public int insertOne(Order order);
    //删除订单
    public int deleteOne(int orderId);
    //更新订单
    public int updateOne(@Param("order") Order order, @Param("orderId") int orderId);

//    [TODO] 取消订单 - 设置订单状态为cancel即可
    public int cancel(int userId, int restaurantId);

//    [TODO] 根据用户id，获取该用户所有订单
    public ArrayList<Order> getAll(int userId) throws Exception;

    public int addFood2Order(FoodItem foodItem) throws Exception;
}
