package cn.forage.model;

import cn.forage.enums.OrderState;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
//该类的设计有一定问题，可以不必理会，太过复杂了
public class Order {
    private int id;
//    订单编号
    private Timestamp code;
    private Address address;
//    订单状态
    private OrderState state;
    private Date createTime;
    private Date finishTime;
//    下单人
    private User user;
//    店铺
    private Restaurant restaurant;
//    食品项{food,num}
    private ArrayList<FoodItem> foodItems;
//    订单总价
    private float cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCode() {
        return code;
    }

    public void setCode(Timestamp code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
