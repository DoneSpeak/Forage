package cn.forage.dao;

import cn.forage.model.FoodItem;
import cn.forage.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by Adminstrator on 2017/5/20.
 */
public interface CartDao extends Dao<FoodItem>,PageDao<FoodItem> {
    public ArrayList<FoodItem> getAllFoods(@Param("userId") int userId, @Param("restaurantId") int restaurantId) throws Exception;

    // [TODO]
    public int addFood( int userId, int restaurantId, int foodId) throws  Exception;

    //[TODO]
    public int reduceFood( int userId, int restaurantId, int foodId) throws  Exception;

    //[TODO]
    public int clearCart( int userId, int restaurantId) throws  Exception;

    //    [TODO]
    public int moveCart2Order(int userId, int restaurantId) throws Exception;
}
