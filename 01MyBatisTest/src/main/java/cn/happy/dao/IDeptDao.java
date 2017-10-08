package cn.happy.dao;

import cn.happy.entity.Dept;

import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public interface IDeptDao {
    /*查询全部用户*/
    public List<Dept> findall();
    /*模糊查询部门*/
    public List<Dept> findlikedept(Dept dept);
    /*一对多单条sql*/
    public Dept findById(int deptno);
    /*一对多多条sql*/
    public Dept findMutliSQL(int deptno);
}
