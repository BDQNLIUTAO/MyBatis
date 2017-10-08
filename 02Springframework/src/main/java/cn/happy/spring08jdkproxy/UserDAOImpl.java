package cn.happy.spring08jdkproxy;

/**
 * Created by Administrator on 2017/10/1.
 */
public class UserDAOImpl implements IUserDAO {
    public String add() {
        System.out.println("add ok!");
        return "add";
    }

    public String edit() {
        System.out.println("edit ok!");
        return "edit";
    }
}
