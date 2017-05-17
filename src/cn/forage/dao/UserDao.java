package cn.forage.dao;

import cn.forage.model.User;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface UserDao extends Dao<User>,PageDao<User> {
    public User getUser(String username, String password);
    public boolean isExist(User user);
}
