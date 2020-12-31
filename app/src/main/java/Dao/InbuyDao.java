package Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DButil.SqlHelper;
import Entity.Inbuy;

public class InbuyDao {
    public static List<Inbuy> allInbuys() {
        List<Inbuy> inbuyList = new ArrayList<Inbuy>();
        String sql = "select * from Inb";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Inbuy inbuy = new Inbuy();
                inbuy.setId(resultSet.getString(1));
                inbuy.setName(resultSet.getString(2));
                inbuy.setPrice(resultSet.getInt(3));
                inbuy.setIntime(resultSet.getDate(4));
                inbuy.setCount(resultSet.getInt(5));
                inbuy.setUni(resultSet.getString(6));
                inbuyList.add(inbuy);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return inbuyList;
    }

    public static List<Inbuy> selectInbuyById(String id) {
        List<Inbuy> inbuyList = new ArrayList<Inbuy>();
        String sql = "select * from Inb where Iid='"+id+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Inbuy inbuy = new Inbuy();
                inbuy.setId(resultSet.getString(1));
                inbuy.setName(resultSet.getString(2));
                inbuy.setPrice(resultSet.getInt(3));
                inbuy.setIntime(resultSet.getDate(4));
                inbuy.setCount(resultSet.getInt(5));
                inbuy.setUni(resultSet.getString(6));
                inbuyList.add(inbuy);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return inbuyList;
    }

    public static List<Inbuy> selectInbuyByName(String name) {
        List<Inbuy> inbuyList = new ArrayList<Inbuy>();
        String sql = "select * from Inb where Iname='"+name+"'";
        ResultSet resultSet = SqlHelper.executeQuery(sql);
        try {
            while (resultSet.next()) {
                Inbuy inbuy = new Inbuy();
                inbuy.setId(resultSet.getString(1));
                inbuy.setName(resultSet.getString(2));
                inbuy.setPrice(resultSet.getInt(3));
                inbuy.setIntime(resultSet.getDate(4));
                inbuy.setCount(resultSet.getInt(5));
                inbuy.setUni(resultSet.getString(6));
                inbuyList.add(inbuy);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return inbuyList;
    }

    public static int addInbuy(String id, String name, int price, String time, int count, String uni) {
        String sql = "insert into Inb values('"+id+"','"+name+"','"+price+"','"+time+"','"+count+"','"+uni+"')";
        return SqlHelper.executeUpdate(sql);
    }

    public static int updateInbuy(String id,String name,int price,String time,int count,String uni) {
        String sql="update Inb set Iname='"+name+"',Iprice='"+price+"',Iintime='"+time+"',Icount='"+count+"',Iuni='"+uni+"' where Iid='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteInbuyById(String id) {
        String sql="delete from Inb where Iid='"+id+"'";
        return SqlHelper.executeUpdate(sql);
    }

    public static int deleteInbuyByName(String name) {
        String sql="delete from Inb where Iname='"+name+"'";
        return SqlHelper.executeUpdate(sql);
    }
}
