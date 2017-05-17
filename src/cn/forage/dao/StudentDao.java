package cn.forage.dao;

import org.springframework.transaction.annotation.Transactional;

import cn.forage.model.Student;

/**
 * Created by DoneSpeak on 2017/5/17.
 */
@Transactional
public interface StudentDao {
//    测试使用
    Student findById(int uid);
    Student findByAge(int age);
    int deleteById(int uid);
    int insert(Student student) throws Exception;
}
