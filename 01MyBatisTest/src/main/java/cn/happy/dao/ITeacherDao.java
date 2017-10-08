package cn.happy.dao;

import cn.happy.entity.Teacher;

/**
 * Created by Administrator on 2017/9/23.
 */
public interface ITeacherDao {
    //根据老师编号查询老师教的所有学员的信息集合
    public Teacher getTeacherById(int tid);
}
