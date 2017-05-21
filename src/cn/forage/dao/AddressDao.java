package cn.forage.dao;

import cn.forage.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface AddressDao extends Dao<User>,PageDao<User> {

    public ArrayList getAllAddr(int userId);

    //删查改方法成功的话，结果返回均为1;失败的话，返回的结果为0
    //public User getUserByphoneNum(String phoneNum);//通过phoneNum返回User对象

}
