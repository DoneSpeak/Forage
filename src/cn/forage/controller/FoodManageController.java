package cn.forage.controller;

import cn.forage.dao.FoodDao;
import cn.forage.model.Food;
import cn.forage.model.Result;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by JIANG on 2017/5/18.
 */
/**这个类处理“菜品管理”的后台事物*/
@Controller
@RequestMapping("/FoodManage")
public class FoodManageController {

    /**操作数据库的对象*/
    @Resource
    FoodDao foodDao;

    /**项数据库添加菜品*/
    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    @ResponseBody
    public Result addFood(HttpServletRequest req){

        // 返回结果对象
        Result result = new Result();
        try {
            // 解析菜品
            Food food = this.parseFood(req);

            if(food==null){
                result.status = Result.ERROR;
                result.message = "文件上传异常或信息格式不正确";
                return result;
            }

            System.out.println(food);

            int count = -1;
            try {
                foodDao.addOne(food);
            }catch(Exception ex){
                ex.printStackTrace();

                result.status = Result.ERROR;
                result.message = "添加失败";

                return result;
            }

            if (count == 1) {
                //添加成功
                result.status = Result.OK;
                result.message = "添加成功";
            } else {
                result.status = Result.ERROR;
                result.message = "添加失败";
            }
            return result;
        }catch (UnsupportedEncodingException e){
            result.status = Result.ERROR;
            result.message = "字符编码不支持";
            return result;
        }


    }


    /**更新菜品*/
    @RequestMapping(value = "/updateFood" ,method = RequestMethod.POST)
    @ResponseBody
    public Result updateFood(HttpServletRequest req){

        // 返回结果对象
        Result result = new Result();
        try {
            // 解析菜品
            Food food = this.parseFood(req);

            if(food==null){
                result.status=Result.ERROR;
                result.message = "文件上传异常或信息格式不正确";
            }

            int count = -1;
            try {
                count = foodDao.updateOne(food);
            }catch (Exception ex){
                ex.printStackTrace();
                result.status = Result.ERROR;
                result.message = "修改失败";
            }

            if (count == 1) {
                //修改成功
                result.status = Result.OK;
                result.message = "修改成功";
            } else {
                result.status = Result.ERROR;
                result.message = "修改失败";
            }
        }catch (UnsupportedEncodingException e){
            result.status = Result.ERROR;
            result.message = "字符编码不支持";

        }finally {
            return result;
        }

    }

    /**删除菜品 */
    @RequestMapping(value = "/deleteFood" ,method = RequestMethod.POST)
    @ResponseBody
    public Result deleteFood(String ids){

        ids = ids.substring(0,ids.lastIndexOf(","));
        ids = "{"+ids +"}";

        // 返回的操作结果对象
        Result result = null;

        int count = -1;

        try{
            count = foodDao.deleteIn(ids);
        }catch(Exception ex){
            ex.printStackTrace();
            result.status = Result.ERROR;
            result.message = "删除失败";
        }

        if(count==-1){
            // 删除失败
            result.status = Result.ERROR;
            result.message = "删除失败";
        }else{
            // 删除成功
            result.status = Result.OK;
            result.message = "成功删除 "+count+" 条记录";
        }

        return result;

    }


    /**获取菜品列表*/
    @RequestMapping(value = "/getFoodList" ,method = RequestMethod.POST)
    @ResponseBody
    public ArrayList<Food> getFoodList(String page,HttpSession session){
        System.out.println(page);
//        User uert = (User)session.getAttribute("user");
//        session.setAttribute("user",new User());


        /**这里要有foodDao对象查询数据库，并返回所有查询结果*/
        ArrayList<Food> foods = new ArrayList<>();
        for(int i=0;i<10;i++){
            Food food = new Food();
            food.setId(i);
            food.setName("name:"+i);
            food.setPrice(i);
            food.setUnit("unit:"+i);
            food.setPicture("url:"+i);
            food.setType("type:蔬菜");
            foods.add(food);
        }
        return foods;

    }


    /**把提交的表单解析成food对象*/
    private Food parseFood(HttpServletRequest req) throws UnsupportedEncodingException {

        Food  food = new Food();

        // 设置编码方式
        req.setCharacterEncoding("UTF-8");

        DiskFileItemFactory factory = new DiskFileItemFactory();

        //设置内存临界值
        factory.setSizeThreshold(10 * 1024 * 1024);

        //设置临时文件夹
//        factory.setRepository(new File(System.getProperty("java.io.tmp")));

        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

        //设置上传文件的大小限制
        servletFileUpload.setFileSizeMax(30 * 1024 * 1024);
        servletFileUpload.setSizeMax(50 * 1024 * 1024);
        try {
            List<FileItem> fileItems = servletFileUpload.parseRequest(req);
            for (FileItem fileItem : fileItems) {
                if (fileItem.isFormField()) {
                    // 上传项是普通字段
                    String fieldName = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    switch (fieldName) {
                        case "id":
                            food.setId(Integer.parseInt(value.length()==0?"-1":value));
                        case "name":
                            food.setName(value);
                            break;
                        case "price":
                            food.setPrice(Float.parseFloat(value));
                            break;
                        case "unit":
                            food.setUnit(value);
                            break;
                        case "type":
                            food.setType(value);
                            break;
                        default:
                            break;
                    }
                    System.out.println(fieldName+":"+value);
                } else {
                    //上传的是文件

                    // 获取一个独一无二的数字
                    UUID uuid = UUID.randomUUID();
                    //获取文件名称
                    String fileName = fileItem.getName();
                    fileName = uuid + "_" + fileName;
                    String picture = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/img/" + fileName;
                    System.out.println(picture);
                    food.setPicture(picture);

                    new File(req.getServletContext().getRealPath("/img")).mkdir();

                    fileItem.write(new File(req.getServletContext().getRealPath("/img"), fileName));


                }
            }// end for

        } catch (FileUploadException e) {
            food = null;
            e.printStackTrace();
        } catch (Exception e) {
            food = null;
            e.printStackTrace();
        }
        return food;
    }

}
