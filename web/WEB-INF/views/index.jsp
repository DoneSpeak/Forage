<%@page import="com.sun.corba.se.impl.protocol.RequestDispatcherRegistryImpl" %>
<%@ page language="java" import="java.util.Date" import="java.util.*" import="java.sql.*" import="java.text.*"
         import="java.security.MessageDigest"
         pageEncoding="utf-8" %>
<%@ page import="cn.forage.model.FoodItem" %>
<%@ page import="cn.forage.model.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
  <link href="bootstrap-3.3.0/css/bootstrap.min.css" rel="stylesheet"/>
  <!--<link href="css/global.css" rel="stylesheet"/>-->
  <link href="css/non-responsive.css" rel="stylesheet">
  <link href="css/global.css" rel="stylesheet">
  <link href="css/index.css" rel="stylesheet">
  <title>觅食</title>
</head>
<body>
<!--顶上小导航栏-->
  <div class="header-slim">
    <nav class="navbar">
        <div class="container">
          <div class="tag-left">
            <a href="#"></a>
          </div>
          <div class="tag-right header-slim-link">
            <span>
              <a href="#">登录</a>&nbsp;|&nbsp;<a href="#">注册</a>
            </span>
            <a href="#">帮助中心</a>
            <a href="#">问题反馈</a>
            <a href="#">联系客服</a>
          </div>
        </div>
    </nav>
  </div>
<!--主要导航栏-->
  <div class="header-bar-container">
    <nav class="navbar">
      <div class="container">
        <div class="row">
          <div class="navbar-header col-xs-3 header-bar-item">
            <a href="#" class="navbar-brand">
              <img src="img/logo.png" />
            </a>
          </div>
          <div class="col-xs-2 header-bar-item">
            <a href="#">首页</a>
          </div>
          <div class="col-xs-2 header-bar-item">
            <a href="#">我的订单</a>
          </div>
          <div class="col-xs-2 header-bar-item">
            <a href="#">入驻加盟</a>
          </div>
          <div class="col-xs-3 header-bar-item">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-default" type="button">Go!</button>
              </span>
            </div><!-- /input-group -->
          </div>
        </div>
      </div>
    </nav>
  </div>

  <div class="cantainer main">
      <%
           //属性名称需要进行修改"foodItems"
          ArrayList<Restaurant> restaurant_list = (ArrayList<Restaurant>) request.getAttribute("restaurants");

          for (int index = 0; index < restaurant_list.size();index++) {
              Restaurant restaurant = restaurant_list.get(index);
              if (index+1==1) {
                  //System.out.println("before--" + index);
      %>
    <div class="row shop-list-row">
        <%
            }
        %>
      <div class="col-xs-3 card-shop">
        <div class="preview">
          <img src="<%=restaurant.getRestaurantImg()%>"/>
        </div>
        <div class="content">
          <div class="name"><%=restaurant.getName()%></div>
          <div class="location"><%=restaurant.getLocation()%></div>
        </div>
      </div>





        <%if (index+1!=1&&(index+1) % 4 == 0) {
            //System.out.println("after--" + index);%>
        <div class="divider-rest clear"></div>
    </div>

              <%if(index+1!=restaurant_list.size())%>
          <div class="row shop-list-row">
              <%
                      }
                  }
              %>


    <div class="row add-more">
      加载更多
    </div>
  </div><!--container main-->

  <div class="container footer">
    <div class="row">
      <div class="col-xs-5 border-right">
        <ul class="tag-left">
          <li><a href="#">我要开店</a></li>
          <li><a href="#">配送加盟</a></li>
          <li><a href="#">城市代理</a></li>
        </ul>
        <ul class="tag-left">
          <li><a href="#">开放平台</a></li>
          <li><a href="#">关于觅食</a></li>
          <li><a href="#">媒体报道</a></li>
        </ul>
        <ul class="tag-left">
          <li><a href="#">常见问题</a></li>
          <li><a href="#">用户反馈</a></li>
          <li><a href="#">加入我们</a></li>
        </ul>
      </div>
      <div class="col-xs-3 border-right">
        <div class="service-phone-number">1010-9777</div>
        <div class="service-detail">
          <p>周一至周日 9:00-23:00</p>
          <p>客服不受理商务合作</p>
        </div>
      </div>
      <div class="col-xs-4">
      </div>
    </div>
  </div>
  <div class="container copyright">
    <p>&copy;2017 forage.cn 开发者：杨观荣 | 刘基雄 | 姜剑辉 | 徐荣钦 | 吴超均</p>
  </div>
</body>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="bootstrap-3.3.0/js/bootstrap.min.js"></script>
<!-- scrollbar 必须在jquery和bootstrap后面 -->
<script src="js/scrollbar.js"></script>
</html>