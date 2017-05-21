package cn.forage.dao;

import cn.forage.model.FoodItem;
import cn.forage.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface FoodDao extends PageDao<FoodItem>{
    public ArrayList<FoodItem>  getFoodsByRestName(String name);
    public ArrayList<FoodItem> getAllFoods(int restaurantId);
    public int addOneFood(FoodItem item);
    public int deleteOneFood(@Param("id") int id, @Param("restaurantId") int restaurantId);
    public int updateOneFood(FoodItem item);
    //得到每一份商品的月售份额
    public int getSellNum(@Param("foodId") int foodId, @Param("startTime") Date startTime, @Param("finishTime") Date finishTime);

    public int deleteIn(String ids) throws Exception;

    /*public int amount(int res_id);
    public ArrayList<FoodItem> getFoodList(int res_id,int offset,int rowsize);*/
    //获取页

}
