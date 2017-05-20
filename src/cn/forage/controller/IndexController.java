package cn.forage.controller;

import cn.forage.dao.RestaurantDao;
import cn.forage.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by DoneSpeak on 2017/5/20.
 */
@Controller
public class IndexController {
    @Autowired
    RestaurantDao restDao;

    @RequestMapping("/index")
    public String index(Model model){
//        ArrayList<Restaurant> restList = null;
//        try {
//            restList = (ArrayList<Restaurant>) restDao.getAll();
//        }catch(Exception ex){
//            ex.printStackTrace();
//            return "404";
//        }
//        model.addAttribute("restList",restList);
        return "index";
    }

}
