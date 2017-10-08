package cn.happy.dao;

import cn.happy.entity.Category;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface ICategoryDao {
    //查询某个pid对应的所有分类的集合
    public List<Category> getChildrenListByPid(int pid);
}
