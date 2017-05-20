package cn.forage.model;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public class Result {
    public static final int OK = 1;
    public static final int ERROR = 0;

    public int status;
    public String message;

    public Result(){}

    public Result(int status,String message){
        this.status = status;
        this.message = message;
    }
}
