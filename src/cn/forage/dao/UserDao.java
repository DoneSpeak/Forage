package cn.forage.dao;

import cn.forage.model.User;

import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface UserDao extends Dao<User>,PageDao<User> {

    //删查改方法成功的话，结果返回均为1;失败的话，返回的结果为0
    public User getUserByphoneNum(String phoneNum);//通过phoneNum返回User对象

// 通过phoneNum 和 password 查找
    public User getUser(String phoneNum, String password);

//    判断是否已有商铺
    public boolean hasRestaurant(int id);

}
