package cn.happy.test;

import cn.happy.dao.IUserInfoDao;
import cn.happy.util.MyBatisUtil;
import cn.happy.entity.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/9/14.
 */
public class Test20170914 {
    /*智能标签forEach array*/
    @Test
    public void fingByforEach() throws IOException {
        SqlSession session= MyBatisUtil.getSession();
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        int[] ids={7,8};
        List<UserInfo> list=mapper.findByForeachArray(ids);
        for (UserInfo userInfo:list){
            System.out.println(userInfo.getName());
        }
        session.close();
    }
    /*智能标签choose*/
    @Test
    public void fingBychoose() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        UserInfo user=new UserInfo();
        user.setName("大");
        user.setAge(20);
        List<UserInfo> list=mapper.findBychoose(user);
        for (UserInfo userInfo:list){
            System.out.println(userInfo.getName());
        }
        session.close();
    }
    /*智能标签if*/
    @Test
    public void fingByif() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        UserInfo user=new UserInfo();
        user.setName("大");
        user.setAge(20);
        List<UserInfo> list=mapper.findByif(user);
        for (UserInfo userInfo:list){
            System.out.println(userInfo.getName());
        }
        session.close();
    }
    /*查询用户*/
    @Test
    public void testall() throws IOException {

        SqlSession session= MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        List<UserInfo> list=mapper.findall();
        System.out.println(list);
        for (UserInfo user: list){
            System.out.println(user.getName());
        }
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*多条件按索引按索引号查询*/
    @Test
    public void findStudentInfoByManyCondition() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        List<UserInfo> list=mapper.findUserInfoByManyConditionByIndex("大",20);
        for (UserInfo userInfo:list){
            System.out.println(userInfo.getName());
        }
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*多条件查询用户*/
    @Test
    public void testById() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        UserInfo userInfo = mapper.getUserResultMapById(3);
        System.out.println(userInfo.getName());
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*添加用户*/
    @Test
    public void testadd() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        List<UserInfo> list=mapper.findall();
        UserInfo user=new UserInfo();
        System.out.println("添加之前"+user.getId());
        user.setName("大乐");
        user.setSex("男");
        mapper.adduser(user);
        session.commit();
        System.out.println("添加之后"+user.getId());
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*修改用户*/
    @Test
    public void testedit() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        //class<T>:类型的类型
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        List<UserInfo> list=mapper.findall();
        UserInfo user=new UserInfo();
        user.setName("大亮6");
        user.setSex("女");
        user.setId(6);
        mapper.edituser(user);
        session.commit();
        //关闭会话，释放资源，提高性能
        session.close();
    }
    /*删除用户*/
    @Test
    public void testdel() throws IOException {
        SqlSession session=MyBatisUtil.getSession();
        //1.4 调度selectList方法执行sql，并且获取结果
        IUserInfoDao mapper=session.getMapper(IUserInfoDao.class);
        List<UserInfo> list=mapper.findall();
        UserInfo user=new UserInfo();
        mapper.deluser(4);
        session.commit();
        //关闭会话，释放资源，提高性能
        session.close();
    }
}
