package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DButil.SqlHelper;
import Entity.User;

public class UserDao {

    public static List<User> allUsers() {
        List<User> userList = new ArrayList<User>();
        String sql = "select * from User";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setUserid(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setName(resultSet.getString(3));
                user.setUni(resultSet.getString(4));
                userList.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public static int addDiary(String id,String ip,String time) {
        String sql = "insert into Diary values('"+id+"','"+ip+"','"+time+"')";
        return SqlHelper.executeUpdate(sql);
    }

    public static int addUser(String id,String pwd,String name,String uni) {
        String sql = "insert into User values('"+id+"','"+pwd+"','"+name+"','"+uni+"')";
        return SqlHelper.executeUpdate(sql);
    }
}
