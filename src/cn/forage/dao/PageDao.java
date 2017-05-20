package cn.forage.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface PageDao<T> {
    public ArrayList<T> getFirstPage(int pageSize) throws Exception;
    public ArrayList<T> getLastPage(int pageSize) throws Exception;
    public ArrayList<T> getOnePage(@Param("pageSize") int pageSize, @Param("index") int index) throws Exception;
    public ArrayList<T> getPage(@Param("pageSize") int pageSize, @Param("startIndex") int startIndex) throws Exception;
    public int getPageAmount(int pageSize) throws Exception;
}
