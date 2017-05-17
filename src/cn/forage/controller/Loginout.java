package cn.forage.controller;

import cn.forage.dao.UserDao;
import cn.forage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
@Controller
public class Loginout {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password){
        User user = userDao.getUser(username,password);
        String result = "";
        if(user == null){
//            空 - 表示用户不存在
            result = "{\"status\":\"0\",\"message\":\"密码输出错误或者用户名错误\"}";
        }else{
//            用户存在
//            密码清空
            user.setPassword("");
//            存入 session 中

            result = "{\"status\":\"1\",\"message\":\"登录成功\"}";
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(){
//        判断用户是否已经登录，登录后才能登出
//        清空sessiong
        return "index";
    }

    @RequestMapping("/signup")
    @ResponseBody
    public String logout(User user, String repassword){
        String result = "";
//        先判断用户是否已经注册
//        已注册
        if(userDao.isExist(user)){
            return "{\"status\":\"0\",\"message\":\"用户已存在\"}";
        }

//        未注册 -- 注册
        try {
            userDao.addOne(user);
        } catch (Exception e) {
//            处理错误
            e.printStackTrace();
            return "{\"status\":\"0\",\"message\":\"无法注册\"}";
        }
//        清空密码
        user.setPassword("");
//        写入session中
        return "{\"status\":\"1\",\"message\":\"注册成功\"}";
    }
}
