package cn.forage.dao;

import cn.forage.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface UserDao extends Dao<User> {

    //删查改方法成功的话，结果返回均为1;失败的话，返回的结果为0
    public User getUserByphoneNum(String phoneNum);//通过phoneNum返回User对象
    public User getUser(@Param("userName") String userName, @Param("password") String password);
    //获取页
    public ArrayList<User> getFirstPage(int pageSize) throws Exception;
    public ArrayList<User> getLastPage(int pageSize) throws Exception;
    public ArrayList<User> getOnePage(@Param("pageSize") int pageSize, @Param("index") int index) throws Exception;
    public int getPageAmount(int pageSize) throws Exception;

    public int isExist(User user)throws Exception;

    public int hasRestaurant(int id);
}
