package cn.forage.controller;

import cn.forage.dao.RestaurantDao;
import cn.forage.dao.UserDao;
import cn.forage.model.Restaurant;
import cn.forage.model.User;
import cn.forage.utils.EncoderUtil;
import jdk.nashorn.internal.runtime.regexp.joni.constants.RegexState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
@Controller
@RequestMapping("/")
public class LoginoutController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RestaurantDao restDao;

    @RequestMapping("/signin")
    @ResponseBody
    public String signin(String username, String password){
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

    @RequestMapping("/signout")
    public String signout(HttpSession session){
        session.removeAttribute("user");
        session.removeAttribute("restaurant");
        return "index";
    }

    @RequestMapping("/signup")
    @ResponseBody
    public String signup(User user, String repassword, HttpSession session){
        String result = "";
        EncoderUtil encoder = new EncoderUtil();
//        加密
        repassword = encoder.sha(repassword);
        if(!repassword.equals(user.getPassword())){
            return "{\"status\":\"0\",\"message\":\"两次输入密码不匹配\"}";
        }
//        先判断用户是否已经注册
//        已注册
        if(userDao.isExist(user)){
            return "{\"status\":\"0\",\"message\":\"用户已存在\"}";
        }

//        未注册 -- 注册
        int id = -1;
        try {
           id = userDao.addOne(user);
        } catch (Exception e) {
//            处理错误
            e.printStackTrace();
            return "{\"status\":\"0\",\"message\":\"无法注册\"}";
        }
//        设置用户id
        user.setId(id);
//        清空密码
        user.setPassword("");
//        写入session中
        session.setAttribute("user",user);
        return "{\"status\":\"1\",\"message\":\"注册成功\"}";
    }

    @RequestMapping("/restsignup")
    @ResponseBody
    public String restsignup(Restaurant rest, HttpSession session){
        String result = "";
        User user = (User)session.getAttribute("user");
//        先判断用户是否已经注册
//        已注册
        if(userDao.hasRestaurant(user.getId())){
            return "{\"status\":\"0\",\"message\":\"用户已有商铺\"}";
        }
        int id = -1;
        try {
            id = restDao.addOne(rest);
        } catch (Exception e) {
//            处理错误
            e.printStackTrace();
            return "{\"status\":\"0\",\"message\":\"无法注册\"}";
        }
        rest.setId(id);
//        写入session中
        session.setAttribute("restaurant",rest);
        return "{\"status\":\"1\",\"message\":\"注册成功\"}";
    }
}
