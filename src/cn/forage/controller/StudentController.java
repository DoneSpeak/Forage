package cn.forage.controller;

import cn.forage.dao.RestaurantDao;
import cn.forage.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.forage.dao.StudentDao;
import cn.forage.model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
//声明为控制器
@Controller
//@RequestMapping("/index")
//不配置该类的路径，则默认为根路径
public class StudentController {
    @Autowired
    private StudentDao stuDao;
    @Autowired
    private RestaurantDao restDao;

    @RequestMapping("/index")
    @ResponseBody
//    含有 @ResponseBody ,返回相当于respond.write，对应ajax请求的返回
    public Restaurant getStu(){
        Restaurant rest = null;
        try{
            rest = restDao.getOne(7);
            System.out.print(rest.getName());
        }catch(Exception e){
            System.err.print(e);
            System.out.print(e);
        }
//        Student stu = stuDao.findById(27);
//        stuDao.deleteById(31);

        return rest;
    }

    @RequestMapping(value = "/getStu")
//    @ResponseBody
//    public String getStuUrl(HttpServletRequest request){
    public String getStuUrl(){
        Student stu = new Student();
        stu.setName("haha");
        stu.setAge(12);
        int i = -1;
        try {
            i = stuDao.insert(stu);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.print("测试" + i);

//        与下面的Model相同 - 传递数据到
//        request.setAttribute("student", stu);
        return "index";
    }

    @RequestMapping("/getStuDb")
//    去除ResponseBody，返回值为视图的值，在设置中，该方法对应视图：WEB-INF/views/index.jsp
    public String getStudb(Model model){

        Student stu = stuDao.findById(27);
        model.addAttribute("student",stu);

        return "index";
    }

    public static void main(String[] args){
        StudentController tst = new StudentController();
        Restaurant rest = tst.getStu();
        System.out.print(rest.getName());
    }
}
