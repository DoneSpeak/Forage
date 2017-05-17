package cn.forage.dao;

import java.util.ArrayList;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
public interface PageDao<T> {
    public ArrayList<T> getFirstPage(int pageSize) throws Exception;
    public ArrayList<T> getLastPage(int pageSize) throws Exception;
    public ArrayList<T> getOnePage(int pageSize, int index) throws Exception;
    public int getPageAmount(int pageSize) throws Exception;
}
