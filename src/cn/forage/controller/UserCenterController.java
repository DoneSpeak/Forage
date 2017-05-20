package cn.forage.controller;

import cn.forage.dao.RestaurantDao;
import cn.forage.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by JIANG on 2017/5/18.
 */

@Controller
@RequestMapping("/UserCenter")
public class UserCenterController {


    @Resource
    private RestaurantDao restaurantDao;


    @RequestMapping("updateRestaurant")
    @ResponseBody
    public String updateRestaurant(){

        return null;
    }


}













