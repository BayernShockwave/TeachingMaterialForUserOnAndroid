package Dao;

import DButil.SqlHelper;

public class EmailDao {
    public static int addRequest(String id,String email,String request) {
        String sql = "insert into Em values('"+id+"','"+email+"','"+request+"')";
        return SqlHelper.executeUpdate(sql);
    }
}
