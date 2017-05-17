package cn.forage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.forage.dao.StudentDao;
import cn.forage.model.Student;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
//声明为控制器
@Controller
//@RequestMapping("/admin")
//不配置该类的路径，则默认为根路径
public class StudentController {
    @Autowired
    private StudentDao stuDao;

    @RequestMapping("/getStuAjax")
    @ResponseBody
//    含有 @ResponseBody ,返回相当于respond.write，对应ajax请求的返回
    public Student getStu(){
        Student stu = stuDao.findById(27);
        return stu;
    }

    @RequestMapping(value = "/getStu")
    public String getStuUrl(HttpServletRequest request){
        Student stu = new Student();
        stu.setUid(1);
        stu.setName("haha");
        stu.setAge(12);
        int i = 0;
        try {
            i = stuDao.insert(stu);
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.print("测试");

//        与下面的Model相同 - 传递数据到
        request.setAttribute("student", stu);
        return "index";
    }

    @RequestMapping("/getStuDb")
//    去除ResponseBody，返回值为视图的值，在设置中，该方法对应视图：WEB-INF/views/index.jsp
    public String getStudb(Model model){

        Student stu = stuDao.findById(27);
        model.addAttribute("student",stu);

        return "index";
    }
}
