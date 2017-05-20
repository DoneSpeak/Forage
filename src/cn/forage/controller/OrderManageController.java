package cn.forage.controller;

import cn.forage.dao.OrderDao;
import cn.forage.dao.UserDao;
import cn.forage.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JIANG on 2017/5/18.
 */


@Controller
@RequestMapping("/OrderManage")
public class OrderManageController {

    @Resource
    private OrderDao OrderDao;


    @RequestMapping("getOrderList")
    @ResponseBody
    public ArrayList<Order> getOrderList(){

        ArrayList<Order> orders = new ArrayList<>();


        return orders;
    }
}
