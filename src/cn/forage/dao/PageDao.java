package cn.forage.dao;

import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface PageDao<T> {

    public int getAmount(int id);
    public ArrayList<T> getFirstPage(@Param("id") int id, @Param("offset") int offset, @Param("pageSize") int pageSize) throws Exception;
    public ArrayList<T> getLastPage(@Param("id") int id, @Param("offset") int offset, @Param("pageSize") int pageSize) throws Exception;
    public ArrayList<T> getOnePage(@Param("id") int id, @Param("offset") int offset, @Param("pageSize") int pageSize) throws Exception;
}
