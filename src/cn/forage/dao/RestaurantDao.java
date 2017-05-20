package cn.forage.dao;

import cn.forage.model.Restaurant;
import cn.forage.model.User;

import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface RestaurantDao  extends Dao<Restaurant>,PageDao<Restaurant> {
    public Restaurant getOneRestaurantByphoneNum(String phoneNum);//通过phoneNum返回Restaurant对象

}
